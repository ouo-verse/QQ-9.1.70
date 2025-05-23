package com.tencent.mobileqq.dpc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QMMKVMigrateHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$CPU;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Camera;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$DeviceInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Memory;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$OS;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$RespGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Screen;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Storage;
import com.tencent.mobileqq.cooperation.a;
import com.tencent.mobileqq.dpc.api.IDPCAccountService;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.api.impl.DPCAccountServiceImpl;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.m;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.base.config.data.k;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import javax.xml.parsers.SAXParserFactory;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.inject.MqqInjectorManager;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes10.dex */
public class DeviceProfileManager {
    static IPatchRedirector $redirector_ = null;
    private static final String BRAOD_CAST_PERMISSION = "com.tencent.msg.permission.pushnotify";
    private static final String[] DPCCONFIGINFO_FILEDS;
    private static final String DPC_CHANGE_BROAD_CAST = "com.tentcent.mobileqq.dpc.broadcast";
    private static final int DPC_RSP_LOG_TYPE_ACCOUNT_MANAGER = 1;
    private static final int DPC_RSP_LOG_TYPE_TMP_FEATURE_MAP_NEW = 3;
    private static final int DPC_RSP_LOG_TYPE_TMP_FEATURE_MAP_OLD = 4;
    private static final int DPC_RSP_LOG_TYPE_TMP_MAP = 2;
    public static final String KEY_AB_TEST_RAND = "ab_rand";
    public static final String KEY_ACCOUNT_LAST_UPDATE_TIME = "account_last_update_time";
    public static final String KEY_KEYTYPE = "key_type";
    public static final String KEY_LAST_UPDATE_TIME = "last_update_time";
    public static final String KEY_SERVER_VISION = "server_version";
    public static final String KEY_VERSIONCODE = "key_versioncode";
    public static final int MAX_AB_RANDOM_VALUE = 10000;
    private static final Object OBSERVER_LOCK;
    public static final String TAG = "DeviceProfileManager";
    private static List<DPCObserver> dpcObservers;
    private static Field[] fields;
    public static boolean isInited;
    private static volatile DeviceProfileManager mInstance;
    public static DPCAccountServiceImpl sAccountDpcService;
    boolean isRegisteredBroadCast;
    public int mAbRamdom;
    private HashMap<String, DPCConfigInfo> mFeatureDefaultMap;
    private HashMap<String, DPCConfigInfo> mFeatureMapLV2;
    private BroadcastReceiver mReceiver;
    private AtomicInteger mServerDataCurrentState;

    /* loaded from: classes10.dex */
    public static class DPCConfigInfo implements Cloneable, Serializable {
        static IPatchRedirector $redirector_ = null;
        public static final String DPCINFO_FEATUREVALUE_DEFAULTVAL = "";
        public String featureValue;

        public DPCConfigInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.featureValue = "";
            }
        }

        public Object clone() {
            DPCConfigInfo dPCConfigInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, (Object) this);
            }
            try {
                dPCConfigInfo = (DPCConfigInfo) super.clone();
            } catch (CloneNotSupportedException e16) {
                e16.printStackTrace();
                dPCConfigInfo = null;
            }
            if (dPCConfigInfo == null) {
                return this;
            }
            dPCConfigInfo.featureValue = this.featureValue;
            return dPCConfigInfo;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder(64);
            sb5.append("DPCConfigInfo: featureValue=");
            sb5.append(this.featureValue);
            return sb5.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class DPCXmlHandler extends DefaultHandler {
        static IPatchRedirector $redirector_;
        private Pattern checkPattern;
        private boolean mIsText;

        /* renamed from: sb, reason: collision with root package name */
        private StringBuffer f203600sb;
        private String taskId;
        public HashMap<String, DPCXMLParseInfo> tempMap;
        public String testType;
        private int weight;

        /* loaded from: classes10.dex */
        static class DPCXMLParseInfo {
            static IPatchRedirector $redirector_;
            public String key;
            public String taskId;
            public String testType;
            public String value;
            public int weight;

            DPCXMLParseInfo() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                    return;
                }
                this.key = "";
                this.value = "";
                this.weight = 0;
                this.taskId = "0";
                this.testType = "";
            }

            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "DPCXMLParseInfo: key=" + this.key + ",value=" + this.value + ",weight=" + this.weight + ",taskId=" + this.taskId + ",testType=" + this.testType;
            }
        }

        public DPCXmlHandler(HashMap<String, DPCXMLParseInfo> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) hashMap);
                return;
            }
            this.f203600sb = new StringBuffer();
            this.mIsText = false;
            this.weight = 0;
            this.taskId = "0";
            this.testType = "";
            this.checkPattern = Pattern.compile("^([0-9]{1,5}|\\{([\\s\\S]*)\\})$");
            this.tempMap = hashMap;
        }

        private boolean checkFormat(String str) {
            if (str != null && str.length() != 0) {
                return this.checkPattern.matcher(str).matches();
            }
            return false;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i3, int i16) throws SAXException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, cArr, Integer.valueOf(i3), Integer.valueOf(i16));
            } else if (this.mIsText) {
                this.f203600sb.append(cArr, i3, i16);
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, str, str2, str3);
                return;
            }
            if (this.mIsText) {
                if (!checkFormat(this.f203600sb.toString())) {
                    if (QLog.isColorLevel()) {
                        QLog.e(DeviceProfileManager.TAG, 2, "DPCXmlHandler format is error: " + str2 + "-" + this.f203600sb.toString());
                        return;
                    }
                    return;
                }
                if (this.tempMap.containsKey(str2)) {
                    DPCXMLParseInfo dPCXMLParseInfo = this.tempMap.get(str2);
                    if (QLog.isColorLevel()) {
                        QLog.d(DeviceProfileManager.TAG, 2, "DPCXmlHandler parse to TEMPMAP update oldInfo: " + str2 + "-" + dPCXMLParseInfo.toString());
                    }
                    int i3 = dPCXMLParseInfo.weight;
                    int i16 = this.weight;
                    if (i3 < i16) {
                        dPCXMLParseInfo.weight = i16;
                        dPCXMLParseInfo.value = this.f203600sb.toString();
                        dPCXMLParseInfo.taskId = this.taskId;
                        dPCXMLParseInfo.testType = this.testType;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(DeviceProfileManager.TAG, 2, "DPCXmlHandler parse to TEMPMAP update newInfo: " + str2 + "-" + dPCXMLParseInfo.toString());
                    }
                } else {
                    DPCXMLParseInfo dPCXMLParseInfo2 = new DPCXMLParseInfo();
                    dPCXMLParseInfo2.key = str2;
                    dPCXMLParseInfo2.value = this.f203600sb.toString();
                    dPCXMLParseInfo2.taskId = this.taskId;
                    dPCXMLParseInfo2.weight = this.weight;
                    dPCXMLParseInfo2.testType = this.testType;
                    this.tempMap.put(str2, dPCXMLParseInfo2);
                    if (QLog.isColorLevel()) {
                        QLog.d(DeviceProfileManager.TAG, 2, "DPCXmlHandler parse to TEMPMAP add: " + str2 + "-" + dPCXMLParseInfo2.toString());
                    }
                }
            }
            this.mIsText = false;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startDocument() throws SAXException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            super.startDocument();
            if (this.tempMap == null) {
                this.tempMap = new HashMap<>();
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, str, str2, str3, attributes);
                return;
            }
            if (str2.equals(k.FEATURES_KEY)) {
                for (int i3 = 0; i3 < attributes.getLength(); i3++) {
                    if (attributes.getLocalName(i3).equals("weight")) {
                        this.weight = Integer.parseInt(attributes.getValue(i3));
                    } else if (attributes.getLocalName(i3).equals(MiniAppGetGameTaskTicketServlet.KEY_TASKID)) {
                        this.taskId = attributes.getValue(i3);
                    } else if (attributes.getLocalName(i3).equals("testType")) {
                        this.testType = attributes.getValue(i3);
                    }
                }
                return;
            }
            this.mIsText = true;
            StringBuffer stringBuffer = this.f203600sb;
            stringBuffer.delete(0, stringBuffer.length());
        }
    }

    /* loaded from: classes10.dex */
    public static class SimpleStringParser implements StringParser<String> {
        static IPatchRedirector $redirector_;

        public SimpleStringParser() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.dpc.DeviceProfileManager.StringParser
        public String parse(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? str : (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
    }

    /* loaded from: classes10.dex */
    public interface StringParser<T> {
        T parse(String str);
    }

    /* loaded from: classes10.dex */
    public static class StringToIntParser implements StringParser<Integer> {
        static IPatchRedirector $redirector_;

        public StringToIntParser() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tencent.mobileqq.dpc.DeviceProfileManager.StringParser
        public Integer parse(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? Integer.decode(str) : (Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34477);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        DPCCONFIGINFO_FILEDS = new String[]{"featureValue"};
        isInited = false;
        OBSERVER_LOCK = new Object();
    }

    DeviceProfileManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.mFeatureMapLV2 = new HashMap<>();
        this.mFeatureDefaultMap = new HashMap<>();
        this.mServerDataCurrentState = new AtomicInteger(1);
        this.mReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.dpc.DeviceProfileManager.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DeviceProfileManager.this);
                }
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                    return;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.e(DeviceProfileManager.TAG, 4, "onReceive");
                }
                if (intent == null) {
                    return;
                }
                try {
                    Bundle extras = intent.getExtras();
                    if (extras == null) {
                        return;
                    }
                    DeviceProfileManager.this.mFeatureMapLV2 = (HashMap) extras.getSerializable("featureMapLV2");
                    DPCAccountServiceImpl dPCAccountServiceImpl = DeviceProfileManager.sAccountDpcService;
                    if (dPCAccountServiceImpl != null) {
                        dPCAccountServiceImpl.mFeatureAccountMapLV2 = (HashMap) extras.getSerializable("featureAccountMapLV2");
                    }
                } catch (Exception e16) {
                    if (QLog.isDevelopLevel()) {
                        e16.printStackTrace();
                    }
                }
            }
        };
        this.isRegisteredBroadCast = false;
        init(MobileQQ.sProcessId != 9);
    }

    public static void addObserver(DPCObserver dPCObserver) {
        synchronized (OBSERVER_LOCK) {
            if (dpcObservers == null) {
                dpcObservers = new ArrayList();
            }
            if (dPCObserver != null && !dpcObservers.contains(dPCObserver)) {
                dpcObservers.add(dPCObserver);
            }
        }
    }

    public static ConfigurationService$ReqGetConfig buidldReqConfig(AppRuntime appRuntime) {
        ConfigurationService$Camera configurationService$Camera;
        int i3;
        ConfigurationService$OS configurationService$OS = new ConfigurationService$OS();
        configurationService$OS.setHasFlag(true);
        configurationService$OS.type.set(2);
        configurationService$OS.kernel.set(ah.B());
        configurationService$OS.sdk.set(String.valueOf(ah.K()));
        configurationService$OS.version.set(ah.t());
        configurationService$OS.rom.set(ah.S());
        ConfigurationService$CPU configurationService$CPU = new ConfigurationService$CPU();
        configurationService$CPU.setHasFlag(true);
        configurationService$CPU.model.set(ah.o());
        configurationService$CPU.cores.set(ah.n());
        configurationService$CPU.frequency.set((int) ah.l());
        ConfigurationService$Memory configurationService$Memory = new ConfigurationService$Memory();
        configurationService$Memory.setHasFlag(true);
        configurationService$Memory.total.set(m.c());
        configurationService$Memory.process.set(ah.E());
        ConfigurationService$Storage configurationService$Storage = new ConfigurationService$Storage();
        configurationService$Storage.setHasFlag(true);
        configurationService$Storage.builtin.set(ah.Y());
        long[] U = ah.U();
        configurationService$Storage.external.set((U[0] * 1048576) + (U[1] * 1024 * 1024));
        ConfigurationService$Screen configurationService$Screen = new ConfigurationService$Screen();
        configurationService$Screen.setHasFlag(true);
        configurationService$Screen.model.set("");
        configurationService$Screen.width.set((int) ah.x());
        configurationService$Screen.height.set((int) ah.w());
        configurationService$Screen.dpi.set(ah.v());
        configurationService$Screen.multi_touch.set(ah.q0());
        ConfigurationService$Camera configurationService$Camera2 = new ConfigurationService$Camera();
        configurationService$Camera2.setHasFlag(true);
        configurationService$Camera2.primary.set(0L);
        configurationService$Camera2.secondary.set(0L);
        configurationService$Camera2.flash.set(false);
        ConfigurationService$ConfigSeq configurationService$ConfigSeq = new ConfigurationService$ConfigSeq();
        configurationService$ConfigSeq.setHasFlag(true);
        configurationService$ConfigSeq.type.set(4);
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences mMKVMigratedSharePreferencesSync = QMMKVMigrateHelper.getMMKVMigratedSharePreferencesSync(appRuntime.getApplicationContext(), IDPCApiConstant.DPCCONFIG_ACCOUNT_SHAREPRE_NAME, 4);
        if (mMKVMigratedSharePreferencesSync == null) {
            QLog.e(TAG, 1, "buidldReqConfig fail, accountDpcSP is null");
            return new ConfigurationService$ReqGetConfig();
        }
        long j3 = mMKVMigratedSharePreferencesSync.getLong(DPCAccountServiceImpl.buildAccountDpcSPName(appRuntime, KEY_LAST_UPDATE_TIME), 0L);
        int a16 = a.a(appRuntime.getApplicationContext());
        int i16 = mMKVMigratedSharePreferencesSync.getInt(KEY_VERSIONCODE, 0);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            configurationService$Camera = configurationService$Camera2;
            sb5.append("DeviceProfileManager.KEY_LAST_UPDATE_TIME=");
            sb5.append(j3);
            sb5.append(",nowSystemTime=");
            sb5.append(currentTimeMillis);
            sb5.append("versionCode=");
            sb5.append(a16);
            sb5.append(",key_versioncode=");
            sb5.append(i16);
            QLog.d(TAG, 2, sb5.toString());
        } else {
            configurationService$Camera = configurationService$Camera2;
        }
        if (!MqqInjectorManager.instance().isDebugVersion() && 172800 > Math.abs(currentTimeMillis - j3) / 1000 && i16 >= a16) {
            i3 = mMKVMigratedSharePreferencesSync.getInt(DPCAccountServiceImpl.buildAccountDpcSPName(appRuntime, KEY_SERVER_VISION), 0);
        } else {
            i3 = 0;
        }
        configurationService$ConfigSeq.version.set(i3);
        ArrayList arrayList = new ArrayList();
        arrayList.add(configurationService$ConfigSeq);
        ConfigurationService$DeviceInfo configurationService$DeviceInfo = new ConfigurationService$DeviceInfo();
        configurationService$DeviceInfo.setHasFlag(true);
        configurationService$DeviceInfo.brand.set(ah.C());
        configurationService$DeviceInfo.model.set(ah.s());
        configurationService$DeviceInfo.f202980os = configurationService$OS;
        configurationService$DeviceInfo.cpu = configurationService$CPU;
        configurationService$DeviceInfo.memory = configurationService$Memory;
        configurationService$DeviceInfo.storage = configurationService$Storage;
        configurationService$DeviceInfo.screen = configurationService$Screen;
        configurationService$DeviceInfo.f202979camera = configurationService$Camera;
        ConfigurationService$ReqGetConfig configurationService$ReqGetConfig = new ConfigurationService$ReqGetConfig();
        configurationService$ReqGetConfig.device_info = configurationService$DeviceInfo;
        configurationService$ReqGetConfig.seq_list.addAll(arrayList);
        printReqInfo(configurationService$ReqGetConfig);
        return configurationService$ReqGetConfig;
    }

    public static boolean buildDPCConfigValue(DPCConfigInfo dPCConfigInfo, String str) {
        if (str == null || str.length() == 0 || dPCConfigInfo == null) {
            return false;
        }
        String[] strArr = {str.trim()};
        if (fields == null) {
            fields = new Field[DPCCONFIGINFO_FILEDS.length];
            int i3 = 0;
            while (true) {
                Field[] fieldArr = fields;
                if (i3 >= fieldArr.length) {
                    break;
                }
                try {
                    fieldArr[i3] = dPCConfigInfo.getClass().getField(DPCCONFIGINFO_FILEDS[i3]);
                    fields[i3].setAccessible(true);
                } catch (NoSuchFieldException e16) {
                    e16.printStackTrace();
                    fields[i3] = null;
                }
                i3++;
            }
        }
        int min = Math.min(fields.length, 1);
        boolean z16 = false;
        for (int i16 = 0; i16 < min; i16++) {
            String str2 = strArr[i16];
            if (str2 != null && str2.length() != 0) {
                if (str2.indexOf(123, 0) == 0 && str2.lastIndexOf(125) == str2.length() - 1) {
                    str2 = str2.substring(1, str2.length() - 1);
                }
                try {
                    Field field = fields[i16];
                    if (field != null && !str2.equals((String) field.get(dPCConfigInfo))) {
                        fields[i16].set(dPCConfigInfo, str2);
                        z16 = true;
                    }
                } catch (IllegalAccessException e17) {
                    e17.printStackTrace();
                } catch (IllegalArgumentException e18) {
                    e18.printStackTrace();
                }
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeDpcSpOperation(SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            QLog.e(TAG, 1, "init fail, spLV2 is null");
            return;
        }
        int i3 = sharedPreferences.getInt(KEY_AB_TEST_RAND, -1);
        this.mAbRamdom = i3;
        if (i3 == -1) {
            this.mAbRamdom = new Random().nextInt(10000);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit != null) {
                edit.putInt(KEY_AB_TEST_RAND, this.mAbRamdom);
                edit.apply();
            }
        }
    }

    private DPCConfigInfo getFeatureInfo(String str) {
        HashMap<String, DPCConfigInfo> hashMap;
        if (DPCAccountServiceImpl.accountDpcNames.contains(str)) {
            if (sAccountDpcService == null) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "getFeatureValue() accountDpcManager is null");
                    return null;
                }
                return null;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getFeatureValue() accountDpcNames=" + str);
            }
            DPCAccountServiceImpl dPCAccountServiceImpl = sAccountDpcService;
            hashMap = dPCAccountServiceImpl.mFeatureAccountMapLV2;
            str = dPCAccountServiceImpl.buildAccountDpcName(str);
        } else {
            hashMap = this.mFeatureMapLV2;
        }
        DPCConfigInfo dPCConfigInfo = hashMap.get(str);
        if (dPCConfigInfo == null && MobileQQ.sProcessId == 9) {
            return getFeatureInfoSync(str);
        }
        return dPCConfigInfo;
    }

    public static DeviceProfileManager getInstance() {
        return getInstance(MobileQQ.sMobileQQ.peekAppRuntime());
    }

    public static DeviceProfileManager getInstanceWithoutAccountManager() {
        if (mInstance == null) {
            synchronized (DeviceProfileManager.class) {
                if (mInstance == null) {
                    mInstance = new DeviceProfileManager();
                }
            }
        }
        return mInstance;
    }

    private void init(boolean z16) {
        DPCConfigInfo dPCConfigInfo;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "DeviceProfileManager init DPC content");
        }
        isInited = true;
        initDefaultValue();
        SharedPreferences mMKVMigratedSharePreferencesSync = QMMKVMigrateHelper.getMMKVMigratedSharePreferencesSync(MobileQQ.sMobileQQ.getApplicationContext(), IDPCApiConstant.DPCCONFIG_SHAREPRE_NAME, 4);
        if (((IDPCApi) QRoute.api(IDPCApi.class)).isLoadDpcSpToggleEnable()) {
            ThreadManagerV2.excute(new Runnable(mMKVMigratedSharePreferencesSync) { // from class: com.tencent.mobileqq.dpc.DeviceProfileManager.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ SharedPreferences val$spLV2;

                {
                    this.val$spLV2 = mMKVMigratedSharePreferencesSync;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) DeviceProfileManager.this, (Object) mMKVMigratedSharePreferencesSync);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        DeviceProfileManager.this.executeDpcSpOperation(this.val$spLV2);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            }, 64, null, true);
        } else {
            executeDpcSpOperation(mMKVMigratedSharePreferencesSync);
        }
        if (!z16) {
            return;
        }
        for (DPCNames dPCNames : DPCNames.values()) {
            String string = mMKVMigratedSharePreferencesSync.getString(dPCNames.name(), "");
            if ("".equals(string)) {
                dPCConfigInfo = (DPCConfigInfo) this.mFeatureDefaultMap.get(dPCNames.name()).clone();
            } else {
                DPCConfigInfo dPCConfigInfo2 = new DPCConfigInfo();
                buildDPCConfigValue(dPCConfigInfo2, string);
                dPCConfigInfo = dPCConfigInfo2;
            }
            this.mFeatureMapLV2.put(dPCNames.name(), dPCConfigInfo);
        }
    }

    private void initDefaultValue() {
        for (DPCNames dPCNames : DPCNames.values()) {
            this.mFeatureDefaultMap.put(dPCNames.name(), new DPCConfigInfo());
        }
        DPCConfigInfo dPCConfigInfo = new DPCConfigInfo();
        dPCConfigInfo.featureValue = "1";
        this.mFeatureDefaultMap.put(DPCNames.magicface_support.name(), dPCConfigInfo);
        DPCConfigInfo dPCConfigInfo2 = new DPCConfigInfo();
        dPCConfigInfo2.featureValue = "1";
        this.mFeatureDefaultMap.put(DPCNames.h5magic_support.name(), dPCConfigInfo2);
        new DPCConfigInfo().featureValue = "1";
        this.mFeatureDefaultMap.put(DPCNames.aio_eggs.name(), dPCConfigInfo);
        DPCConfigInfo dPCConfigInfo3 = new DPCConfigInfo();
        dPCConfigInfo3.featureValue = HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.f198084lr);
        this.mFeatureDefaultMap.put(DPCNames.OneyWayDateMsgNotifyCfg.name(), dPCConfigInfo3);
        DPCConfigInfo dPCConfigInfo4 = new DPCConfigInfo();
        dPCConfigInfo4.featureValue = HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.f198074lq);
        this.mFeatureDefaultMap.put(DPCNames.OneyWayLBSFriendMsgNotifyCfg.name(), dPCConfigInfo4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyHasDpcChanged(boolean z16) {
        nextServerDataState(4);
        Intent intent = new Intent(DPC_CHANGE_BROAD_CAST);
        Bundle bundle = new Bundle();
        bundle.putSerializable("featureMapLV2", this.mFeatureMapLV2);
        DPCAccountServiceImpl dPCAccountServiceImpl = sAccountDpcService;
        if (dPCAccountServiceImpl != null) {
            bundle.putSerializable("featureAccountMapLV2", dPCAccountServiceImpl.mFeatureAccountMapLV2);
        }
        intent.putExtras(bundle);
        MobileQQ.sMobileQQ.getApplicationContext().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
        notifyObservers(z16);
    }

    private static void notifyObservers(boolean z16) {
        synchronized (OBSERVER_LOCK) {
            List<DPCObserver> list = dpcObservers;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                DPCObserver dPCObserver = dpcObservers.get(size);
                if (dPCObserver != null) {
                    dPCObserver.onDpcPullFinished(z16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDPCResponseClrLog(boolean z16, int i3, Object obj) {
        if (!z16) {
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        return;
                    }
                    return;
                }
                return;
            }
            Object[] objArr = (Object[]) obj;
            QLog.d(TAG, 2, "onDPCResponse DPCXmlHandler.tempMap: key=" + objArr[0] + ", value=" + objArr[1] + ", isAccountName=" + objArr[2]);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.e(TAG, 2, "onDPCResponse() accountDpcManager or responseUin is null");
        }
    }

    public static <T> int parseComplexParams(String str, T[] tArr, StringParser<T> stringParser) {
        int i3 = 0;
        if (tArr == null || stringParser == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            String[] split = str.split("\\|");
            int min = Math.min(split.length, tArr.length);
            while (i3 < min) {
                try {
                    tArr[i3] = stringParser.parse(split[i3]);
                    i3++;
                } catch (Exception e16) {
                    e = e16;
                    i3 = min;
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "Parse ComplexParams failed:" + e);
                        return i3;
                    }
                    return i3;
                }
            }
            return min;
        } catch (Exception e17) {
            e = e17;
        }
    }

    private static void printReqInfo(ConfigurationService$ReqGetConfig configurationService$ReqGetConfig) {
        ConfigurationService$DeviceInfo configurationService$DeviceInfo = configurationService$ReqGetConfig.device_info;
        StringBuilder sb5 = new StringBuilder(1024);
        sb5.append("config.version = " + configurationService$ReqGetConfig.seq_list.get(0).version.get() + "\n");
        sb5.append("buidldReqConfig{");
        sb5.append(" brand= ");
        sb5.append(configurationService$DeviceInfo.brand.get());
        sb5.append(" ,model= ");
        sb5.append(configurationService$DeviceInfo.model.get());
        sb5.append(" ,os.type= ");
        sb5.append(configurationService$DeviceInfo.f202980os.type.get());
        sb5.append(" ,os.kernel= ");
        sb5.append(configurationService$DeviceInfo.f202980os.kernel.get());
        sb5.append(" ,os.sdk= ");
        sb5.append(configurationService$DeviceInfo.f202980os.sdk.get());
        sb5.append(" ,os.version= ");
        sb5.append(configurationService$DeviceInfo.f202980os.version.get());
        sb5.append(" ,os.rom= ");
        sb5.append(configurationService$DeviceInfo.f202980os.rom.get());
        sb5.append(" ,cpu.model= ");
        sb5.append(configurationService$DeviceInfo.cpu.model.get());
        sb5.append(" ,cpu.cores= ");
        sb5.append(configurationService$DeviceInfo.cpu.cores.get());
        sb5.append(" ,cpu.frequency= ");
        sb5.append(configurationService$DeviceInfo.cpu.frequency.get());
        sb5.append(" ,memory.total= ");
        sb5.append(configurationService$DeviceInfo.memory.total.get());
        sb5.append(" ,memory.process= ");
        sb5.append(configurationService$DeviceInfo.memory.process.get());
        sb5.append(" ,storage.builtin= ");
        sb5.append(configurationService$DeviceInfo.storage.builtin.get());
        sb5.append(" ,storage.external= ");
        sb5.append(configurationService$DeviceInfo.storage.external.get());
        sb5.append(" ,screen.model= ");
        sb5.append(configurationService$DeviceInfo.screen.model.get());
        sb5.append(" ,screen.width= ");
        sb5.append(configurationService$DeviceInfo.screen.width.get());
        sb5.append(" ,screen.height= ");
        sb5.append(configurationService$DeviceInfo.screen.height.get());
        sb5.append(" ,screen.dpi= ");
        sb5.append(configurationService$DeviceInfo.screen.dpi.get());
        sb5.append(" ,screen.multi_touch= ");
        sb5.append(configurationService$DeviceInfo.screen.multi_touch.get());
        sb5.append(" ,camera.primary= ");
        sb5.append(configurationService$DeviceInfo.f202979camera.primary.get());
        sb5.append(" ,camera.secondary= ");
        sb5.append(configurationService$DeviceInfo.f202979camera.secondary.get());
        sb5.append(" ,camera.flash= ");
        sb5.append(configurationService$DeviceInfo.f202979camera.flash.get());
        sb5.append(" }");
        QLog.i(TAG, 1, sb5.toString());
    }

    public static void removeObserver(DPCObserver dPCObserver) {
        synchronized (OBSERVER_LOCK) {
            List<DPCObserver> list = dpcObservers;
            if (list != null && dPCObserver != null) {
                list.remove(dPCObserver);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateDpcSp(ConfigurationService$Config configurationService$Config, SharedPreferences.Editor editor, SharedPreferences sharedPreferences, SharedPreferences.Editor editor2) {
        DPCAccountServiceImpl dPCAccountServiceImpl = sAccountDpcService;
        if (dPCAccountServiceImpl != null) {
            editor2.putLong(DPCAccountServiceImpl.buildAccountDpcSPName(dPCAccountServiceImpl.mApp, KEY_LAST_UPDATE_TIME), System.currentTimeMillis());
            editor2.putInt(DPCAccountServiceImpl.buildAccountDpcSPName(sAccountDpcService.mApp, KEY_SERVER_VISION), configurationService$Config.version.get());
        }
        int i3 = sharedPreferences.getInt(KEY_VERSIONCODE, 0);
        int a16 = a.a(MobileQQ.sMobileQQ.getApplicationContext());
        if (i3 < a16) {
            editor2.putInt(KEY_VERSIONCODE, a16);
        }
        editor.commit();
        editor2.commit();
        QLog.i(TAG, 1, "onDPCResponse KEY_LAST_UPDATE_TIME=" + System.currentTimeMillis() + ", versioncode=" + a16 + ", keyVersionCode =" + i3);
        return true;
    }

    private void waitDPCServerData(long j3) {
        if (getServerDataCurrentState() != 4) {
            synchronized (this.mServerDataCurrentState) {
                if (getServerDataCurrentState() != 4) {
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "waitDPCServerData() is waiting threadID=" + Thread.currentThread().getId());
                        }
                        this.mServerDataCurrentState.wait(j3);
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 1, "waitDpcServerData failed", e16);
                        }
                    }
                }
            }
        }
    }

    public DPCConfigInfo getFeatureInfoSync(String str) {
        String string;
        DPCConfigInfo dPCConfigInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (DPCConfigInfo) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        if (DPCAccountServiceImpl.accountDpcNames.contains(str)) {
            if (sAccountDpcService == null) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "getFeatureValue() accountDpcManager is null");
                    return null;
                }
                return null;
            }
            SharedPreferences mMKVMigratedSharePreferencesSync = QMMKVMigrateHelper.getMMKVMigratedSharePreferencesSync(MobileQQ.sMobileQQ.getApplicationContext(), IDPCApiConstant.DPCCONFIG_ACCOUNT_SHAREPRE_NAME, 4);
            String buildAccountDpcName = sAccountDpcService.buildAccountDpcName(str);
            String string2 = mMKVMigratedSharePreferencesSync.getString(buildAccountDpcName, "");
            if ("".equals(string2)) {
                DPCConfigInfo dPCConfigInfo2 = sAccountDpcService.mFeatureDefaultAccountMap.get(str);
                if (dPCConfigInfo2 != null) {
                    dPCConfigInfo = (DPCConfigInfo) dPCConfigInfo2.clone();
                } else {
                    dPCConfigInfo = new DPCConfigInfo();
                }
            } else {
                DPCConfigInfo dPCConfigInfo3 = new DPCConfigInfo();
                buildDPCConfigValue(dPCConfigInfo3, string2);
                dPCConfigInfo = dPCConfigInfo3;
            }
            sAccountDpcService.mFeatureAccountMapLV2.put(buildAccountDpcName, dPCConfigInfo);
        } else {
            SharedPreferences mMKVMigratedSharePreferencesSync2 = QMMKVMigrateHelper.getMMKVMigratedSharePreferencesSync(MobileQQ.sMobileQQ.getApplicationContext(), IDPCApiConstant.DPCCONFIG_SHAREPRE_NAME, 4);
            if (mMKVMigratedSharePreferencesSync2 == null) {
                string = "";
            } else {
                string = mMKVMigratedSharePreferencesSync2.getString(str, "");
            }
            if ("".equals(string)) {
                DPCConfigInfo dPCConfigInfo4 = this.mFeatureDefaultMap.get(str);
                if (dPCConfigInfo4 != null) {
                    dPCConfigInfo = (DPCConfigInfo) dPCConfigInfo4.clone();
                } else {
                    dPCConfigInfo = new DPCConfigInfo();
                }
            } else {
                DPCConfigInfo dPCConfigInfo5 = new DPCConfigInfo();
                buildDPCConfigValue(dPCConfigInfo5, string);
                dPCConfigInfo = dPCConfigInfo5;
            }
            this.mFeatureMapLV2.put(str, dPCConfigInfo);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getFeatureInfoSync ", str, " = ", dPCConfigInfo.toString());
        }
        return dPCConfigInfo;
    }

    public synchronized String getFeatureValue(String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        DPCConfigInfo featureInfo = getFeatureInfo(str);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getFeatureValue: ");
            sb5.append(str);
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(featureInfo != null ? featureInfo.toString() : "null");
            QLog.d(TAG, 2, sb5.toString());
        }
        if (featureInfo != null && (str2 = featureInfo.featureValue) != null && str2.length() != 0) {
            return featureInfo.featureValue;
        }
        return "";
    }

    public int getServerDataCurrentState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.mServerDataCurrentState.get();
    }

    public synchronized boolean isFeatureSupported(String str) {
        HashMap<String, DPCConfigInfo> hashMap;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).booleanValue();
        }
        if (DPCAccountServiceImpl.accountDpcNames.contains(str)) {
            if (sAccountDpcService == null) {
                if (QLog.isDevelopLevel()) {
                    QLog.e(TAG, 2, "isFeatureSupported() accountDpcManager is null");
                }
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "isFeatureSupported() accountDpcNames=" + str);
            }
            DPCAccountServiceImpl dPCAccountServiceImpl = sAccountDpcService;
            hashMap = dPCAccountServiceImpl.mFeatureAccountMapLV2;
            str = dPCAccountServiceImpl.buildAccountDpcName(str);
        } else {
            hashMap = this.mFeatureMapLV2;
        }
        DPCConfigInfo dPCConfigInfo = hashMap.get(str);
        if (QLog.isColorLevel() && dPCConfigInfo != null) {
            QLog.d(TAG, 2, "isFeatureSupported: " + str + ContainerUtils.KEY_VALUE_DELIMITER + dPCConfigInfo.toString());
        }
        if (dPCConfigInfo != null && (str2 = dPCConfigInfo.featureValue) != null && str2.length() != 0) {
            if (!dPCConfigInfo.featureValue.equals("0") && !dPCConfigInfo.featureValue.equals("2")) {
                return dPCConfigInfo.featureValue.equals("1");
            }
            return false;
        }
        return false;
    }

    public void nextServerDataState(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        this.mServerDataCurrentState.set(i3);
        if (i3 == 4) {
            synchronized (this.mServerDataCurrentState) {
                this.mServerDataCurrentState.notifyAll();
            }
        }
    }

    public synchronized boolean onDPCResponse(ConfigurationService$RespGetConfig configurationService$RespGetConfig, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) configurationService$RespGetConfig, (Object) str)).booleanValue();
        }
        ThreadManager.getSubThreadHandler().post(new Runnable(configurationService$RespGetConfig, str) { // from class: com.tencent.mobileqq.dpc.DeviceProfileManager.3
            static IPatchRedirector $redirector_;
            final /* synthetic */ ConfigurationService$RespGetConfig val$respGetConfig;
            final /* synthetic */ String val$uin;

            {
                this.val$respGetConfig = configurationService$RespGetConfig;
                this.val$uin = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, DeviceProfileManager.this, configurationService$RespGetConfig, str);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                HashMap<String, DPCConfigInfo> hashMap;
                Object obj;
                HashMap<String, DPCConfigInfo> hashMap2;
                AppRuntime appRuntime;
                String str2;
                HashMap<String, DPCConfigInfo> hashMap3;
                boolean z16;
                SharedPreferences.Editor editor;
                HashMap<String, DPCConfigInfo> hashMap4;
                String str3;
                boolean z17;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                boolean z18 = false;
                ConfigurationService$Config configurationService$Config = this.val$respGetConfig.config_list.get(0);
                PBRepeatField<String> pBRepeatField = configurationService$Config.content_list;
                int i3 = 1;
                QLog.i(DeviceProfileManager.TAG, 1, "onDPCResponse is called, version=" + configurationService$Config.version.get());
                try {
                    if (pBRepeatField != null) {
                        try {
                            if (pBRepeatField.size() != 0 && !TextUtils.isEmpty(this.val$uin)) {
                                HashMap<String, DPCXmlHandler.DPCXMLParseInfo> hashMap5 = new HashMap<>();
                                for (int i16 = 0; i16 < pBRepeatField.size(); i16++) {
                                    if (!DeviceProfileManager.this.parseDPCXML(pBRepeatField.get(i16), hashMap5)) {
                                        QLog.e(DeviceProfileManager.TAG, 1, "onDPCResponse parseDPCXML error, so return");
                                    }
                                }
                                Iterator<Map.Entry<String, DPCXmlHandler.DPCXMLParseInfo>> it = hashMap5.entrySet().iterator();
                                SharedPreferences.Editor edit = QMMKVMigrateHelper.getMMKVMigratedSharePreferencesSync(MobileQQ.sMobileQQ.getApplicationContext(), IDPCApiConstant.DPCCONFIG_SHAREPRE_NAME, 4).edit();
                                SharedPreferences mMKVMigratedSharePreferencesSync = QMMKVMigrateHelper.getMMKVMigratedSharePreferencesSync(MobileQQ.sMobileQQ.getApplicationContext(), IDPCApiConstant.DPCCONFIG_ACCOUNT_SHAREPRE_NAME, 4);
                                SharedPreferences.Editor edit2 = mMKVMigratedSharePreferencesSync.edit();
                                synchronized (DeviceProfileManager.this) {
                                    hashMap = (HashMap) DeviceProfileManager.this.mFeatureMapLV2.clone();
                                    DPCAccountServiceImpl dPCAccountServiceImpl = DeviceProfileManager.sAccountDpcService;
                                    obj = null;
                                    if (dPCAccountServiceImpl != null) {
                                        hashMap2 = (HashMap) dPCAccountServiceImpl.mFeatureAccountMapLV2.clone();
                                    } else {
                                        hashMap2 = null;
                                    }
                                }
                                while (it.hasNext()) {
                                    Map.Entry<String, DPCXmlHandler.DPCXMLParseInfo> next = it.next();
                                    if (next != null) {
                                        String key = next.getKey();
                                        DPCXmlHandler.DPCXMLParseInfo value = next.getValue();
                                        if (!DPCAccountServiceImpl.accountDpcNames.contains(key)) {
                                            hashMap3 = DeviceProfileManager.this.mFeatureDefaultMap;
                                            z16 = z18;
                                            editor = edit;
                                            hashMap4 = hashMap;
                                            str3 = key;
                                        } else {
                                            DPCAccountServiceImpl dPCAccountServiceImpl2 = DeviceProfileManager.sAccountDpcService;
                                            if (dPCAccountServiceImpl2 == null) {
                                                DeviceProfileManager.this.onDPCResponseClrLog(QLog.isColorLevel(), i3, obj);
                                            } else {
                                                hashMap3 = dPCAccountServiceImpl2.mFeatureDefaultAccountMap;
                                                str3 = dPCAccountServiceImpl2.buildAccountDpcName(key);
                                                z16 = i3;
                                                editor = edit2;
                                                hashMap4 = hashMap2;
                                            }
                                        }
                                        Iterator<Map.Entry<String, DPCXmlHandler.DPCXMLParseInfo>> it5 = it;
                                        DeviceProfileManager.this.onDPCResponseClrLog(QLog.isColorLevel(), 1, new Object[]{key, value.toString(), Boolean.valueOf(z16)});
                                        if (hashMap4 != null) {
                                            DPCConfigInfo dPCConfigInfo = hashMap4.get(str3);
                                            if (dPCConfigInfo == null) {
                                                DPCConfigInfo dPCConfigInfo2 = hashMap3.get(str3);
                                                if (dPCConfigInfo2 != null && dPCConfigInfo2.clone() != null) {
                                                    dPCConfigInfo = (DPCConfigInfo) dPCConfigInfo2.clone();
                                                    z17 = true;
                                                }
                                            } else {
                                                z17 = false;
                                            }
                                            DeviceProfileManager.this.onDPCResponseClrLog(QLog.isColorLevel(), 3, new Object[]{str3, dPCConfigInfo, Boolean.valueOf(z17)});
                                            boolean buildDPCConfigValue = DeviceProfileManager.buildDPCConfigValue(dPCConfigInfo, value.value.toString().trim());
                                            if (z17) {
                                                hashMap4.put(str3, dPCConfigInfo);
                                            }
                                            SharedPreferences.Editor editor2 = editor;
                                            if (editor2 != null && (z17 || buildDPCConfigValue)) {
                                                editor2.putString(str3, value.value);
                                            }
                                            it = it5;
                                            z18 = false;
                                            i3 = 1;
                                            obj = null;
                                        }
                                        it = it5;
                                        z18 = false;
                                        i3 = 1;
                                        obj = null;
                                    }
                                }
                                synchronized (DeviceProfileManager.this) {
                                    DeviceProfileManager.this.mFeatureMapLV2 = hashMap;
                                    DPCAccountServiceImpl dPCAccountServiceImpl3 = DeviceProfileManager.sAccountDpcService;
                                    if (dPCAccountServiceImpl3 != null && (appRuntime = dPCAccountServiceImpl3.mApp) != null && (str2 = this.val$uin) != null && str2.equals(appRuntime.getAccount())) {
                                        DeviceProfileManager.sAccountDpcService.mFeatureAccountMapLV2 = hashMap2;
                                    }
                                }
                                boolean updateDpcSp = DeviceProfileManager.this.updateDpcSp(configurationService$Config, edit, mMKVMigratedSharePreferencesSync, edit2);
                                QLog.i(DeviceProfileManager.TAG, 1, "onDPCResponse finally\uff0c hasChanged=" + updateDpcSp);
                                DeviceProfileManager.this.notifyHasDpcChanged(updateDpcSp);
                                return;
                            }
                        } catch (Exception e16) {
                            QLog.e(DeviceProfileManager.TAG, 1, "onDPCResponse exception: ", e16);
                            QLog.i(DeviceProfileManager.TAG, 1, "onDPCResponse finally\uff0c hasChanged=false");
                            DeviceProfileManager.this.notifyHasDpcChanged(false);
                            return;
                        }
                    }
                    QLog.i(DeviceProfileManager.TAG, 1, "onDPCResponse finally\uff0c hasChanged=false");
                    DeviceProfileManager.this.notifyHasDpcChanged(false);
                } catch (Throwable th5) {
                    QLog.i(DeviceProfileManager.TAG, 1, "onDPCResponse finally\uff0c hasChanged=false");
                    DeviceProfileManager.this.notifyHasDpcChanged(false);
                    throw th5;
                }
            }
        });
        return true;
    }

    public boolean parseDPCXML(String str, HashMap<String, DPCXmlHandler.DPCXMLParseInfo> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) hashMap)).booleanValue();
        }
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            SAXParserFactory.newInstance().newSAXParser().parse(new InputSource(new ByteArrayInputStream(str.getBytes("utf-8"))), new DPCXmlHandler(hashMap));
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "pareseDCPXML", e16);
            }
            e16.printStackTrace();
            return false;
        }
    }

    public void printDPCConfigValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder(1024);
            sb5.append("mFeatureMapLV2 start loop: \n");
            for (Map.Entry<String, DPCConfigInfo> entry : this.mFeatureMapLV2.entrySet()) {
                sb5.append("key=" + ((Object) entry.getKey()) + ", value=" + entry.getValue().toString() + "\n");
            }
            sb5.append("mFeatureMapLV2 end loop: \n");
            sb5.append("mFeatureAccountMapLV2 start loop: \n");
            for (Map.Entry<String, DPCConfigInfo> entry2 : sAccountDpcService.mFeatureAccountMapLV2.entrySet()) {
                sb5.append("key=" + ((Object) entry2.getKey()) + ", value=" + entry2.getValue().toString() + "\n");
            }
            sb5.append("mFeatureAccountMapLV2 end loop: \n");
            QLog.i(TAG, 2, sb5.toString());
        }
    }

    public void registerBroadCast(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
            return;
        }
        if (appRuntime != null && !this.isRegisteredBroadCast) {
            Context applicationContext = appRuntime.getApplicationContext();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(DPC_CHANGE_BROAD_CAST);
            try {
                applicationContext.registerReceiver(this.mReceiver, intentFilter, "com.tencent.msg.permission.pushnotify", new Handler(ThreadManagerV2.getSubThreadLooper()));
                this.isRegisteredBroadCast = true;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "registerBroadCast failed! e = " + e16 + " msg = " + e16.getMessage());
                }
            }
        }
    }

    public void unRegisterBroadCast(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            if (appRuntime == null) {
                return;
            }
            try {
                appRuntime.getApplicationContext().unregisterReceiver(this.mReceiver);
            } catch (Exception unused) {
            }
        }
    }

    public static DeviceProfileManager getInstance(AppRuntime appRuntime) {
        if (appRuntime != null) {
            sAccountDpcService = (DPCAccountServiceImpl) appRuntime.getRuntimeService(IDPCAccountService.class, "all");
        }
        if (mInstance == null) {
            synchronized (DeviceProfileManager.class) {
                if (mInstance == null) {
                    mInstance = new DeviceProfileManager();
                }
            }
        }
        return mInstance;
    }

    public synchronized String getFeatureValue(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) str2);
        }
        String featureValue = getFeatureValue(str);
        return (featureValue == null || "".equals(featureValue)) ? str2 : featureValue;
    }

    public String getFeatureValue(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, this, str, Long.valueOf(j3));
        }
        waitDPCServerData(j3);
        return getFeatureValue(str);
    }

    public boolean isFeatureSupported(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, this, str, Long.valueOf(j3))).booleanValue();
        }
        waitDPCServerData(j3);
        return isFeatureSupported(str);
    }
}
