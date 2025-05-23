package com.tencent.zplan.meme.action;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.zplan.common.model.AppTheme;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.common.utils.c;
import com.tencent.zplan.meme.Meme;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.model.AvatarCharacterInfo;
import com.tencent.zplan.meme.model.MemeRecordParams;
import com.tencent.zplan.meme.model.MemeResult;
import com.tencent.zplan.meme.recorder.a;
import com.tencent.zplan.record.recorder.MemeZPlanBatchRecorder;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lx4.d;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import wx4.d;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 X2\u00020\u0001:\u0001XBy\u0012\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00020\r\u0012\u0006\u0010A\u001a\u00020\u0002\u0012\u0006\u0010C\u001a\u00020\u0002\u0012\b\b\u0002\u0010E\u001a\u00020\n\u0012\u0006\u0010H\u001a\u00020G\u0012\u0006\u0010P\u001a\u00020O\u0012\b\b\u0002\u0010L\u001a\u00020\b\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010S\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010S\u00a2\u0006\u0004\bV\u0010WJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0016J\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J!\u0010\u0015\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\u000f\u0010\u001b\u001a\u00020\u0014H\u0010\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u0010\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010!\u001a\u00020\bH\u0010\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010$\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010&\u001a\u00020%H\u0016J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\rH\u0016J\u0010\u0010+\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)H\u0016R\u001a\u0010,\u001a\u00020\u00028\u0016X\u0096D\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\n8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001d\u00105\u001a\b\u0012\u0004\u0012\u00020\u0002048\u0006\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u00106R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u00106R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u00106R \u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020#0<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R \u0010?\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b?\u00106\u001a\u0004\b@\u00108R\u001a\u0010A\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bA\u0010-\u001a\u0004\bB\u0010/R\u001a\u0010C\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bC\u0010-\u001a\u0004\bD\u0010/R\u0017\u0010E\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\bE\u00101\u001a\u0004\bF\u00103R\u001a\u0010H\u001a\u00020G8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u0017\u0010L\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010 \u00a8\u0006Y"}, d2 = {"Lcom/tencent/zplan/meme/action/MemeZPlanBatchAction;", "Lcom/tencent/zplan/meme/action/MemeZPlanBaseAction;", "", "id", "Lcom/tencent/zplan/meme/model/MemeResult;", "getCacheResultById", "result", "Lkotlin/Pair;", "", "saveToLruCache", "", "getIdDesc", "getSingleActionKey", "", "Lcom/tencent/zplan/meme/action/MemeAction$Cache;", "getCachedFiles", "saveCacheFiles", "saveCoverCacheFiles", "portraitId", "success", "", "markOneRecordDone", "(Ljava/lang/Integer;Z)V", "batchCount", "isBatch", "markTryOnce$record_debug", "()V", "markTryOnce", "shouldTryAgain$record_debug", "()Lkotlin/Pair;", "shouldTryAgain", "allDoneForOneTry$record_debug", "()Z", "allDoneForOneTry", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "Lwx4/d;", "getStatisticById", "Lcom/tencent/zplan/meme/model/MemeRecordParams;", "toMemeRecordParams", "Lorg/json/JSONObject;", "toPreDownloadParams", "Ljava/lang/Class;", "Lcom/tencent/zplan/meme/recorder/a;", "getRecorderClazz", "actionId", "I", "getActionId", "()I", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "", "realNeedRecordIds", "Ljava/util/List;", "getRealNeedRecordIds", "()Ljava/util/List;", "allIdsInOneTryRecord", "succeedIdsInOneTryRecord", "failedIdsInOneTryRecord", "", "statisticMap", "Ljava/util/Map;", "portraitIds", "getPortraitIds$record_debug", "width", "getWidth", "height", "getHeight", "uin", "getUin", "Lcom/tencent/zplan/meme/action/MODE;", "mode", "Lcom/tencent/zplan/meme/action/MODE;", "getMode", "()Lcom/tencent/zplan/meme/action/MODE;", "separateSingle", "Z", "getSeparateSingle", "Lcom/tencent/zplan/common/model/AppTheme;", "theme", "senderGender", "receiverGender", "Lcom/tencent/zplan/meme/model/a;", "senderAvatarCharacterInfo", "receiverAvatarCharacterInfo", "<init>", "(Ljava/util/List;IILjava/lang/String;Lcom/tencent/zplan/meme/action/MODE;Lcom/tencent/zplan/common/model/AppTheme;ZLjava/lang/Integer;Ljava/lang/Integer;Lcom/tencent/zplan/meme/model/a;Lcom/tencent/zplan/meme/model/a;)V", "Companion", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public class MemeZPlanBatchAction extends MemeZPlanBaseAction {

    @NotNull
    private static final Companion Companion = new Companion(null);

    @Deprecated
    @NotNull
    public static final String TAG = "[zplan][MemePlayer-Action][MemeZPlanBatchAction]";

    @Deprecated
    @Nullable
    private static final Lazy defaultRecorder$delegate;
    private final int actionId;
    private final List<Integer> allIdsInOneTryRecord;
    private final List<Integer> failedIdsInOneTryRecord;
    private final int height;

    @NotNull
    private final MODE mode;

    @NotNull
    private final String name;

    @NotNull
    private final List<Integer> portraitIds;

    @NotNull
    private final List<Integer> realNeedRecordIds;
    private final boolean separateSingle;
    private final Map<Integer, d> statisticMap;
    private final List<Integer> succeedIdsInOneTryRecord;

    @NotNull
    private final String uin;
    private final int width;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR#\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/zplan/meme/action/MemeZPlanBatchAction$Companion;", "", "Ljava/lang/Class;", "Lcom/tencent/zplan/meme/recorder/a;", "defaultRecorder$delegate", "Lkotlin/Lazy;", "getDefaultRecorder", "()Ljava/lang/Class;", "defaultRecorder", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    private static final class Companion {
        Companion() {
        }

        @Nullable
        public final Class<a> getDefaultRecorder() {
            Lazy lazy = MemeZPlanBatchAction.defaultRecorder$delegate;
            Companion unused = MemeZPlanBatchAction.Companion;
            return (Class) lazy.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Class<a>>() { // from class: com.tencent.zplan.meme.action.MemeZPlanBatchAction$Companion$defaultRecorder$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Class<a> invoke() {
                try {
                    MemeZPlanBatchRecorder.a aVar = MemeZPlanBatchRecorder.Util;
                    return MemeZPlanBatchRecorder.class;
                } catch (Throwable unused) {
                    lx4.d a16 = LogUtil.f385285b.a();
                    if (a16 != null) {
                        d.a.b(a16, MemeZPlanAction.TAG, 1, "cant found default recorder for single record", null, 8, null);
                    }
                    return null;
                }
            }
        });
        defaultRecorder$delegate = lazy;
    }

    public /* synthetic */ MemeZPlanBatchAction(List list, int i3, int i16, String str, MODE mode, AppTheme appTheme, boolean z16, Integer num, Integer num2, AvatarCharacterInfo avatarCharacterInfo, AvatarCharacterInfo avatarCharacterInfo2, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, i3, i16, (i17 & 8) != 0 ? "" : str, mode, appTheme, (i17 & 64) != 0 ? false : z16, (i17 & 128) != 0 ? null : num, (i17 & 256) != 0 ? null : num2, (i17 & 512) != 0 ? null : avatarCharacterInfo, (i17 & 1024) != 0 ? null : avatarCharacterInfo2);
    }

    private final MemeResult getCacheResultById(int id5) {
        String singleActionKey = getSingleActionKey(id5);
        Meme meme = Meme.f385754h;
        File o16 = meme.o(singleActionKey);
        if (o16 == null) {
            return null;
        }
        MemeResult memeResult = new MemeResult(this, singleActionKey, o16.getAbsolutePath());
        memeResult.n(new MemeResult.Sub(id5, singleActionKey));
        if (getConfig().getMp4Config().getCover().getSaveCover()) {
            MemeResult.Cover t16 = meme.t(singleActionKey);
            if (t16 == null) {
                return null;
            }
            memeResult.l(t16);
        }
        if (memeResult.getAction().getConfig().getSaveEachFrame2File()) {
            memeResult.m(meme.u(memeResult.getAction(), singleActionKey));
        }
        LogUtil logUtil = LogUtil.f385285b;
        lx4.d a16 = logUtil.a();
        if (a16 != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("cacheInfo, Id: ");
            sb5.append(id5);
            sb5.append(", path: ");
            sb5.append(o16.getAbsolutePath());
            sb5.append(", properties: ");
            MemeResult.Sub sub = memeResult.getSub();
            Intrinsics.checkNotNull(sub);
            sb5.append(sub.a());
            sb5.append(", frameSize: ");
            sb5.append(memeResult.f().size());
            d.a.c(a16, TAG, 1, sb5.toString(), null, 8, null);
        }
        MemeResult.Sub sub2 = memeResult.getSub();
        if (sub2 != null && sub2.d()) {
            if (sub2.a() == null) {
                lx4.d a17 = logUtil.a();
                if (a17 != null) {
                    d.a.b(a17, TAG, 1, getDesc() + ", id: " + id5 + ", properties file null.", null, 8, null);
                }
                return null;
            }
            return memeResult;
        }
        lx4.d a18 = logUtil.a();
        if (a18 != null) {
            d.a.b(a18, TAG, 1, getDesc() + ", id: " + id5 + ", get cache fail, subResult invalid, sub: " + memeResult.getSub() + '.', null, 8, null);
        }
        return null;
    }

    private final Pair<Boolean, MemeResult> saveToLruCache(MemeResult result) {
        String str;
        MemeResult.Sub sub = result.getSub();
        if (sub != null && sub.d()) {
            String recordPath = result.getRecordPath();
            String subKey = sub.getSubKey();
            int subId = sub.getSubId();
            Meme meme = Meme.f385754h;
            if (!meme.D(recordPath, subKey)) {
                lx4.d a16 = LogUtil.f385285b.a();
                if (a16 != null) {
                    d.a.b(a16, TAG, 1, getDesc() + " recordID: " + subId + ", recordKey: " + subKey + ", save2LRU fail.", null, 8, null);
                }
                return new Pair<>(Boolean.FALSE, result);
            }
            File o16 = meme.o(subKey);
            String str2 = null;
            if (o16 != null) {
                str = o16.getAbsolutePath();
            } else {
                str = null;
            }
            boolean h16 = c.f385288a.h(str);
            Boolean valueOf = Boolean.valueOf(h16);
            if (h16) {
                str2 = str;
            }
            MemeResult memeResult = new MemeResult(this, subKey, str2);
            if (h16) {
                if (getConfig().getSaveEachFrame2File()) {
                    memeResult.m(memeResult.f());
                }
                if (getConfig().getMp4Config().getCover().getSaveCover()) {
                    memeResult.l(result.getCover());
                }
                memeResult.n(new MemeResult.Sub(subId, subKey));
            }
            lx4.d a17 = LogUtil.f385285b.a();
            if (a17 != null) {
                d.a.c(a17, TAG, 1, "saveToLruCache success: " + h16 + ", cacheInfo, Id: " + subId + ", path: " + str, null, 8, null);
            }
            Unit unit = Unit.INSTANCE;
            return new Pair<>(valueOf, memeResult);
        }
        lx4.d a18 = LogUtil.f385285b.a();
        if (a18 != null) {
            d.a.b(a18, TAG, 1, getDesc() + " save to cache fail, record info invalid, sub: " + sub, null, 8, null);
        }
        return new Pair<>(Boolean.FALSE, result);
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    public boolean allDoneForOneTry$record_debug() {
        int size;
        synchronized (this.allIdsInOneTryRecord) {
            size = this.allIdsInOneTryRecord.size();
        }
        if (getRecordDoneCount() == size) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    public int batchCount() {
        return this.portraitIds.size();
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    public boolean clearCache(int id5) {
        String str;
        boolean z16;
        File o16 = Meme.f385754h.o(getSingleActionKey(id5));
        if (o16 != null) {
            str = o16.getAbsolutePath();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return true;
        }
        try {
            c cVar = c.f385288a;
            if (!cVar.h(str)) {
                lx4.d a16 = LogUtil.f385285b.a();
                if (a16 != null) {
                    d.a.b(a16, TAG, 2, getDesc() + " no need to clean, file: " + str + " does not exist.", null, 8, null);
                }
                return true;
            }
            cVar.e(str);
            lx4.d a17 = LogUtil.f385285b.a();
            if (a17 != null) {
                d.a.c(a17, TAG, 1, getDesc() + " clear cache, cachePath: " + str, null, 8, null);
            }
            return true;
        } catch (Throwable th5) {
            lx4.d a18 = LogUtil.f385285b.a();
            if (a18 != null) {
                a18.e(TAG, 1, getDesc() + " clear cache error", th5);
            }
            return false;
        }
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    public int getActionId() {
        return this.actionId;
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    @Nullable
    public List<MemeAction.Cache> getCachedFiles() {
        List list;
        synchronized (this.realNeedRecordIds) {
            list = CollectionsKt___CollectionsKt.toList(this.realNeedRecordIds);
        }
        if (list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            MemeResult cacheResultById = getCacheResultById(intValue);
            if (cacheResultById == null) {
                boolean clearCache = clearCache(intValue);
                lx4.d a16 = LogUtil.f385285b.a();
                if (a16 != null) {
                    d.a.c(a16, TAG, 1, getDesc() + "\uff0csubId:" + intValue + " cache invalid, clearCache success: " + clearCache, null, 8, null);
                }
            } else {
                arrayList.add(new MemeAction.Cache(intValue, cacheResultById));
            }
        }
        lx4.d a17 = LogUtil.f385285b.a();
        if (a17 != null) {
            d.a.c(a17, TAG, 1, getDesc() + ", getCachedFiles, result:" + arrayList, null, 8, null);
        }
        return arrayList;
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    public int getHeight() {
        return this.height;
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    @NotNull
    public String getIdDesc() {
        return "ids:" + this.portraitIds;
    }

    @Override // com.tencent.zplan.meme.action.MemeZPlanBaseAction, com.tencent.zplan.meme.action.MemeAction
    @NotNull
    public MODE getMode() {
        return this.mode;
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public final List<Integer> getPortraitIds$record_debug() {
        return this.portraitIds;
    }

    @NotNull
    public final List<Integer> getRealNeedRecordIds() {
        return this.realNeedRecordIds;
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    @Nullable
    public Class<a> getRecorderClazz() {
        Class<a> recorderClazz = super.getRecorderClazz();
        if (recorderClazz == null) {
            return Companion.getDefaultRecorder();
        }
        return recorderClazz;
    }

    public final boolean getSeparateSingle() {
        return this.separateSingle;
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    @NotNull
    public String getSingleActionKey(int id5) {
        return getKey() + util.base64_pad_url + id5;
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    @NotNull
    public wx4.d getStatisticById(int id5) {
        wx4.d dVar;
        synchronized (this.statisticMap) {
            dVar = this.statisticMap.get(Integer.valueOf(id5));
            if (dVar == null) {
                dVar = r3.b((r51 & 1) != 0 ? r3.evaluateStartTime : 0L, (r51 & 2) != 0 ? r3.evaluateEndTime : 0L, (r51 & 4) != 0 ? r3.scheduledFromQueueTime : 0L, (r51 & 8) != 0 ? r3.evaluateToEngineTime : 0L, (r51 & 16) != 0 ? r3.recordStartTime : 0L, (r51 & 32) != 0 ? r3.recordEndTime : 0L, (r51 & 64) != 0 ? r3.resourceDownloadStartTime : 0L, (r51 & 128) != 0 ? r3.resourceDownloadEndTime : 0L, (r51 & 256) != 0 ? r3.recordFrameCount : 0, (r51 & 512) != 0 ? r3.encodeStartTime : 0L, (r51 & 1024) != 0 ? r3.encodeEndTime : 0L, (r51 & 2048) != 0 ? r3.width : 0, (r51 & 4096) != 0 ? r3.height : 0, (r51 & 8192) != 0 ? r3.mode : null, (r51 & 16384) != 0 ? r3.isBatch : false, (r51 & 32768) != 0 ? r3.appearanceKey : null, (r51 & 65536) != 0 ? r3.hitCache : false, (r51 & 131072) != 0 ? r3.errCode : 0, (r51 & 262144) != 0 ? r3.oom : false, (r51 & 524288) != 0 ? r3.aaType : null, (r51 & 1048576) != 0 ? r3.aaLevel : null, (r51 & 2097152) != 0 ? r3.useRecordV2 : 0, (r51 & 4194304) != 0 ? getStatistic().targetEngineType : null);
                this.statisticMap.put(Integer.valueOf(id5), dVar);
            }
        }
        return dVar;
    }

    @NotNull
    public final String getUin() {
        return this.uin;
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    public int getWidth() {
        return this.width;
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    public boolean isBatch() {
        return true;
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    public void markOneRecordDone(@Nullable Integer portraitId, boolean success) {
        setRecordDoneCount(getRecordDoneCount() + 1);
        if (portraitId != null) {
            int intValue = portraitId.intValue();
            if (success) {
                synchronized (this.realNeedRecordIds) {
                    this.realNeedRecordIds.remove(Integer.valueOf(intValue));
                }
                synchronized (this.succeedIdsInOneTryRecord) {
                    this.succeedIdsInOneTryRecord.add(Integer.valueOf(intValue));
                }
                return;
            }
            synchronized (this.failedIdsInOneTryRecord) {
                this.failedIdsInOneTryRecord.add(Integer.valueOf(intValue));
            }
        }
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    public void markTryOnce$record_debug() {
        super.markTryOnce$record_debug();
        synchronized (this.realNeedRecordIds) {
            synchronized (this.allIdsInOneTryRecord) {
                this.allIdsInOneTryRecord.clear();
                this.allIdsInOneTryRecord.addAll(this.realNeedRecordIds);
            }
        }
        synchronized (this.succeedIdsInOneTryRecord) {
            this.succeedIdsInOneTryRecord.clear();
            Unit unit = Unit.INSTANCE;
        }
        synchronized (this.failedIdsInOneTryRecord) {
            this.failedIdsInOneTryRecord.clear();
        }
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    @NotNull
    public Pair<Boolean, MemeResult> saveCacheFiles(@NotNull MemeResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        lx4.d a16 = LogUtil.f385285b.a();
        if (a16 != null) {
            d.a.c(a16, TAG, 1, "saveCacheFiles, result:" + result + ", frame size:" + result.f().size(), null, 8, null);
        }
        return saveToLruCache(result);
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    @NotNull
    public Pair<Boolean, MemeResult> saveCoverCacheFiles(@NotNull MemeResult result) {
        String str;
        Intrinsics.checkNotNullParameter(result, "result");
        MemeResult.Sub sub = result.getSub();
        if (sub != null) {
            int subId = sub.getSubId();
            String singleActionKey = result.getAction().getSingleActionKey(subId);
            MemeResult.Cover cover = result.getCover();
            if (cover != null) {
                Meme meme = Meme.f385754h;
                if (!meme.D(cover.getPath(), cover.getKey())) {
                    lx4.d a16 = LogUtil.f385285b.a();
                    if (a16 != null) {
                        d.a.b(a16, TAG, 1, getDesc() + " recordID: " + subId + ", recordKey: " + singleActionKey + ", save2LRU fail.", null, 8, null);
                    }
                    return new Pair<>(Boolean.FALSE, result);
                }
                File o16 = meme.o(cover.getKey());
                String str2 = null;
                if (o16 != null) {
                    str = o16.getAbsolutePath();
                } else {
                    str = null;
                }
                boolean h16 = c.f385288a.h(str);
                Boolean valueOf = Boolean.valueOf(h16);
                MemeResult memeResult = new MemeResult(this, singleActionKey, null);
                if (h16) {
                    if (getConfig().getSaveEachFrame2File()) {
                        memeResult.m(memeResult.f());
                    }
                    if (getConfig().getMp4Config().getCover().getSaveCover()) {
                        if (h16) {
                            str2 = str;
                        }
                        memeResult.l(new MemeResult.Cover(str2, cover.getKey()));
                    }
                    memeResult.n(new MemeResult.Sub(subId, singleActionKey));
                }
                lx4.d a17 = LogUtil.f385285b.a();
                if (a17 != null) {
                    d.a.c(a17, TAG, 1, "saveCoverCacheFiles success: " + h16 + ", cacheInfo, Id: " + subId + ", path: " + str, null, 8, null);
                }
                Unit unit = Unit.INSTANCE;
                return new Pair<>(valueOf, memeResult);
            }
            return new Pair<>(Boolean.FALSE, result);
        }
        return new Pair<>(Boolean.FALSE, result);
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    @NotNull
    public Pair<Boolean, Boolean> shouldTryAgain$record_debug() {
        int size;
        int size2;
        int size3;
        boolean z16;
        Pair<Boolean, Boolean> shouldTryAgain$record_debug = super.shouldTryAgain$record_debug();
        boolean booleanValue = shouldTryAgain$record_debug.component1().booleanValue();
        boolean booleanValue2 = shouldTryAgain$record_debug.component2().booleanValue();
        synchronized (this.succeedIdsInOneTryRecord) {
            size = this.succeedIdsInOneTryRecord.size();
        }
        synchronized (this.failedIdsInOneTryRecord) {
            size2 = this.failedIdsInOneTryRecord.size();
        }
        synchronized (this.allIdsInOneTryRecord) {
            size3 = this.allIdsInOneTryRecord.size();
        }
        lx4.d a16 = LogUtil.f385285b.a();
        if (a16 != null) {
            d.a.c(a16, TAG, 2, "shouldTryAgain, superTryAgain:" + booleanValue + ", superRightNow:" + booleanValue2 + ", succeedCount:" + size + ", failedCount:" + size2 + ", allCount:" + size3, null, 8, null);
        }
        Boolean valueOf = Boolean.valueOf(booleanValue);
        if (size + size2 == size3) {
            z16 = true;
        } else {
            z16 = false;
        }
        return new Pair<>(valueOf, Boolean.valueOf(z16));
    }

    @Override // com.tencent.zplan.meme.action.MemeZPlanBaseAction
    @NotNull
    public MemeRecordParams toMemeRecordParams() {
        int[] intArray;
        String key = getKey();
        int taskId = getTaskId();
        MemeRecordParams.User n3 = getSenderInfo().n();
        int frameRate = getFrameRate();
        int frameCount = getMode().toFrameCount();
        int width = getWidth();
        int height = getHeight();
        MODE mode = getMode();
        synchronized (this.realNeedRecordIds) {
            intArray = CollectionsKt___CollectionsKt.toIntArray(this.realNeedRecordIds);
        }
        return new MemeRecordParams(key, 0, taskId, n3, null, frameRate, frameCount, width, height, mode, intArray, AppTheme.INSTANCE.b(getTheme()), true, getConfig(), "N2L_RecordQZoneAvatar", 0, null, 98322, null);
    }

    @Override // com.tencent.zplan.meme.action.MemeZPlanBaseAction
    @NotNull
    public List<JSONObject> toPreDownloadParams() {
        int[] intArray;
        int i3;
        yx4.c cVar = (yx4.c) mx4.a.f417748a.a(yx4.c.class);
        synchronized (this.realNeedRecordIds) {
            intArray = CollectionsKt___CollectionsKt.toIntArray(this.realNeedRecordIds);
        }
        ArrayList arrayList = new ArrayList(intArray.length);
        for (int i16 : intArray) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("actionId", i16);
            jSONObject.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, getTaskId());
            jSONObject.put("frameCount", getMode().toFrameCount());
            if (cVar != null) {
                i3 = cVar.c();
            } else {
                i3 = 6;
            }
            jSONObject.put("parallelNum", i3);
            jSONObject.put("senderGender", getSenderInfo().get_gender());
            jSONObject.put("receiverGender", getReceiverInfo$record_debug().get_gender());
            arrayList.add(jSONObject);
        }
        return arrayList;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemeZPlanBatchAction(@NotNull List<Integer> portraitIds, int i3, int i16, @NotNull String uin, @NotNull MODE mode, @NotNull AppTheme theme, boolean z16, @Nullable Integer num, @Nullable Integer num2, @Nullable AvatarCharacterInfo avatarCharacterInfo, @Nullable AvatarCharacterInfo avatarCharacterInfo2) {
        super(uin, null, mode, theme, num, num2, avatarCharacterInfo, avatarCharacterInfo2);
        List<Integer> mutableList;
        Intrinsics.checkNotNullParameter(portraitIds, "portraitIds");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(theme, "theme");
        this.portraitIds = portraitIds;
        this.width = i3;
        this.height = i16;
        this.uin = uin;
        this.mode = mode;
        this.separateSingle = z16;
        this.name = "";
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) portraitIds);
        this.realNeedRecordIds = mutableList;
        this.allIdsInOneTryRecord = new ArrayList();
        this.succeedIdsInOneTryRecord = new ArrayList();
        this.failedIdsInOneTryRecord = new ArrayList();
        this.statisticMap = new LinkedHashMap();
        if (portraitIds.isEmpty()) {
            throw new IllegalArgumentException("invalid params portraitIds:" + portraitIds);
        }
    }
}
