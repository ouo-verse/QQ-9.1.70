package com.tencent.qqlive.module.videoreport.sample;

import android.text.TextUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfig;
import com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfigAnalyzer;
import com.tencent.qqlive.module.videoreport.sample.model.RemoteKeyMessage;
import com.tencent.qqlive.module.videoreport.sample.model.SampleConfig;
import com.tencent.qqlive.module.videoreport.sample.samplenode.SampleHeadNode;
import com.tencent.qqlive.module.videoreport.sample.samplenode.SampleKVMatchNode;
import com.tencent.qqlive.module.videoreport.sample.samplenode.SampleNode;
import com.tencent.qqlive.module.videoreport.sample.samplenode.SampleRateNode;
import com.tencent.qqlive.module.videoreport.sample.samplenode.SampleVMatchNode;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.DigestHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes22.dex */
class SampleConfigLoader {
    private static final String KEY_CHECK_SUM = "check_sum";
    private static final String KEY_SWITCHES = "switches";
    private static final int SAMPLE_KEY_MESSAGE_LENGTH = 5;
    private static final int SAMPLE_KEY_MESSAGE_SEGMENT_COUNT_INDEX = 3;
    private static final int SAMPLE_KEY_MESSAGE_SEGMENT_INDEX = 4;
    private static final int SAMPLE_KEY_MESSAGE_TIMESTAMP_INDEX = 2;
    private static final String SAMPLE_PREFIX = "sample";
    private static final String SEPARATOR = "\\|";
    private OnConfigLoadedListener listener;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface OnConfigLoadedListener {
        void onConfigLoaded(SampleNode sampleNode);

        void onSubConfigLoaded(SampleNode sampleNode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements Comparator<RemoteKeyMessage> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(RemoteKeyMessage remoteKeyMessage, RemoteKeyMessage remoteKeyMessage2) {
            return remoteKeyMessage.compareByTimestamp(remoteKeyMessage2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements Comparator<RemoteKeyMessage> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(RemoteKeyMessage remoteKeyMessage, RemoteKeyMessage remoteKeyMessage2) {
            return remoteKeyMessage.compareBySegIndex(remoteKeyMessage2);
        }
    }

    private void buildTree(SampleNode sampleNode, List<List<SampleNode>> list, int i3) {
        if (i3 < list.size()) {
            List<SampleNode> list2 = list.get(i3);
            int i16 = i3 + 1;
            Iterator<SampleNode> it = list2.iterator();
            while (it.hasNext()) {
                buildTree(sampleNode.addChildren(createNode(it.next())), list, i16);
            }
        }
    }

    private List<SampleConfig> configsToSampleConfigs(List<String> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            SampleConfig sampleConfig = (SampleConfig) RemoteConfigAnalyzer.analyze(it.next(), SampleConfig.class);
            if (sampleConfig != null) {
                arrayList.add(sampleConfig);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SampleNode convertSampleConfigsToTree(List<SampleConfig> list) {
        SampleHeadNode sampleHeadNode = new SampleHeadNode();
        if (list == null) {
            return sampleHeadNode;
        }
        Iterator<SampleConfig> it = list.iterator();
        while (it.hasNext()) {
            insertSampleConfigToTree(sampleHeadNode, it.next());
        }
        return sampleHeadNode;
    }

    private SampleNode createNode(SampleNode sampleNode) {
        SampleNode sampleRateNode;
        if (sampleNode instanceof SampleVMatchNode) {
            sampleRateNode = new SampleVMatchNode(((SampleVMatchNode) sampleNode).value());
        } else if (sampleNode instanceof SampleKVMatchNode) {
            sampleRateNode = new SampleKVMatchNode(((SampleKVMatchNode) sampleNode).params());
        } else if (sampleNode instanceof SampleRateNode) {
            sampleRateNode = new SampleRateNode(((SampleRateNode) sampleNode).rate());
        } else {
            return sampleNode;
        }
        return sampleRateNode;
    }

    private List<List<SampleNode>> createTable(SampleConfig.Rule rule) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(vMatchedNodes(rule.event));
        arrayList.add(vMatchedNodes(rule.page));
        arrayList.add(vMatchedNodes(rule.element));
        arrayList.add(kvMatchedNodes(rule.params));
        arrayList.add(rateMatchedNodes(rule.sampleRate));
        return arrayList;
    }

    private void insertSampleConfigToTree(SampleNode sampleNode, SampleConfig sampleConfig) {
        for (SampleConfig.Rule rule : sampleConfig.rules) {
            buildTree(sampleNode, createTable(rule), 0);
        }
    }

    private List<SampleNode> kvMatchedNodes(SampleConfig.Param[] paramArr) {
        ArrayList arrayList = new ArrayList(1);
        if (paramArr != null && paramArr.length != 0) {
            arrayList.add(new SampleKVMatchNode(paramArr));
            return arrayList;
        }
        arrayList.add(new SampleVMatchNode("*"));
        return arrayList;
    }

    private List<RemoteKeyMessage> loadAllKeyMessages(RemoteConfig remoteConfig, String str) {
        Set<String> allKeys = remoteConfig.allKeys(str, SAMPLE_PREFIX);
        if (BaseUtils.isEmpty(allKeys)) {
            Log.i(DTConstants.TAG.SAMPLER, "keys empty");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : allKeys) {
            if (str2 != null) {
                String[] split = str2.split("\\.");
                if (split.length == 5) {
                    arrayList.add(new RemoteKeyMessage(str2, split[2], split[3], split[4]));
                }
            }
        }
        if (BaseUtils.isEmpty(arrayList)) {
            Log.i(DTConstants.TAG.SAMPLER, "no matching key");
            return null;
        }
        Collections.sort(arrayList, new a());
        String str3 = arrayList.get(0).timestamp;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            String str4 = arrayList.get(size).timestamp;
            if (str4 != null && !str4.equals(str3)) {
                arrayList.remove(size);
            }
        }
        Collections.sort(arrayList, new b());
        if (!verifySegmentComplete(arrayList)) {
            return null;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<SampleConfig> parseConfig(String str) {
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            arrayList.add(str);
        }
        return configsToSampleConfigs(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<SampleConfig> parseConfigByRemoteConfig(RemoteConfig remoteConfig, String str) {
        ArrayList arrayList = new ArrayList();
        if (remoteConfig.multiSlice()) {
            List<RemoteKeyMessage> loadAllKeyMessages = loadAllKeyMessages(remoteConfig, str);
            if (BaseUtils.isEmpty(loadAllKeyMessages)) {
                return null;
            }
            Iterator<RemoteKeyMessage> it = loadAllKeyMessages.iterator();
            while (it.hasNext()) {
                String configByKey = remoteConfig.getConfigByKey(str, it.next().key);
                if (configByKey != null) {
                    arrayList.add(configByKey);
                }
            }
        } else {
            String configByKey2 = remoteConfig.getConfigByKey(str);
            if (configByKey2 != null) {
                arrayList.add(configByKey2);
            }
        }
        return configsToSampleConfigs(arrayList);
    }

    private List<SampleNode> rateMatchedNodes(double d16) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new SampleRateNode(d16));
        return arrayList;
    }

    private List<SampleNode> vMatchedNodes(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            arrayList.add(new SampleVMatchNode(""));
            return arrayList;
        }
        for (String str2 : str.split(SEPARATOR)) {
            arrayList.add(new SampleVMatchNode(str2));
        }
        return arrayList;
    }

    private boolean verifyDataSecurity(List<String> list) {
        try {
            if (BaseUtils.isEmpty(list)) {
                return false;
            }
            String str = "";
            JsonArray jsonArray = new JsonArray();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                JsonObject asJsonObject = new JsonParser().parse(it.next()).getAsJsonObject();
                jsonArray.addAll(asJsonObject.get(KEY_SWITCHES).getAsJsonArray());
                String asString = asJsonObject.get(KEY_CHECK_SUM).getAsString();
                if (TextUtils.isEmpty(str)) {
                    str = asString;
                } else if (!str.equals(asString)) {
                    return false;
                }
            }
            return str.equals(DigestHelper.md5Hex(jsonArray.toString()));
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    private boolean verifySegmentComplete(List<RemoteKeyMessage> list) {
        if (BaseUtils.isEmpty(list) || Integer.parseInt(list.get(0).segmentCount) != list.size()) {
            return false;
        }
        return true;
    }

    public void load(final String str) {
        ThreadUtils.execTask(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.sample.SampleConfigLoader.1
            @Override // java.lang.Runnable
            public void run() {
                SampleNode convertSampleConfigsToTree = SampleConfigLoader.this.convertSampleConfigsToTree(SampleConfigLoader.this.parseConfig(str));
                if (SampleConfigLoader.this.listener != null) {
                    SampleConfigLoader.this.listener.onConfigLoaded(convertSampleConfigsToTree);
                }
            }
        });
    }

    public void observeSampleConfigLoad(OnConfigLoadedListener onConfigLoadedListener) {
        this.listener = onConfigLoadedListener;
    }

    public void load(final RemoteConfig remoteConfig, final String str) {
        if (remoteConfig == null) {
            return;
        }
        if (!remoteConfig.isInitialized()) {
            Log.d(DTConstants.TAG.SAMPLER, "remote config is not initialized");
        } else {
            ThreadUtils.execTask(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.sample.SampleConfigLoader.2
                @Override // java.lang.Runnable
                public void run() {
                    SampleNode convertSampleConfigsToTree = SampleConfigLoader.this.convertSampleConfigsToTree(SampleConfigLoader.this.parseConfigByRemoteConfig(remoteConfig, str));
                    if (SampleConfigLoader.this.listener != null) {
                        SampleConfigLoader.this.listener.onSubConfigLoaded(convertSampleConfigsToTree);
                    }
                }
            });
        }
    }
}
