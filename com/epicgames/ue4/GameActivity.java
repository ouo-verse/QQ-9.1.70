package com.epicgames.ue4;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.PersistableBundle;
import android.os.PowerManager;
import android.os.Process;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Vibrator;
import android.provider.Settings;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.style.SuggestionSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.epicgames.ue4.Logger;
import com.epicgames.ue4.UE4;
import com.epicgames.ue4.demonetwork.NetStateChangeReceiver;
import com.epicgames.ue4.demonetwork.NetworkType;
import com.gcloudsdk.gcloud.voice.GCloudVoiceEngine;
import com.gcore.gcloud.plugin.GCloudAppLifecycle;
import com.google.android.apps.internal.games.memoryadvice.MemoryAdvisor;
import com.google.vr.sdk.samples.permission.PermissionHelper;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.aelight.camera.download.AEResManagerConfigBean;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.ark.EGLContextHolder;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.gcloud.plugin.PluginUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qfsmonet.gles.MonetEGL14Define$EGLQueryAttribute;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.text.BreakIterator;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.Inflater;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GameActivity extends GameActivityBase implements SurfaceHolder.Callback2, SensorEventListener, Logger.ILoggerCallback, ComponentCallbacks2 {
    private static final int ANDROID_CPU_FAMILY_ARM = 1;
    private static final int ANDROID_CPU_FAMILY_ARM64 = 4;
    private static final int ANDROID_CPU_FAMILY_MIPS = 3;
    private static final int ANDROID_CPU_FAMILY_MIPS64 = 6;
    private static final int ANDROID_CPU_FAMILY_UNKNOWN = 0;
    private static final int ANDROID_CPU_FAMILY_X86 = 2;
    private static final int ANDROID_CPU_FAMILY_X86_64 = 5;
    private static final int CONFIGRULES_STATE_EXECFALSE = 3;
    private static final int CONFIGRULES_STATE_EXECTRUE = 1;
    private static final int CONFIGRULES_STATE_FINDELSE = 2;
    private static final int CONFIGRULES_STATE_FINDEND = 4;
    private static final int CONFIGRULES_STATE_RUN = 0;
    private static final int CONNECTION_TYPE_AIRPLANEMODE = 1;
    private static final int CONNECTION_TYPE_BLUETOOTH = 6;
    private static final int CONNECTION_TYPE_CELL = 3;
    private static final int CONNECTION_TYPE_ETHERNET = 2;
    private static final int CONNECTION_TYPE_NONE = 0;
    private static final int CONNECTION_TYPE_WIFI = 4;
    private static final int CONNECTION_TYPE_WIMAX = 5;
    private static final String DIALOG_ERROR = "dialog_error";
    public static final int DOWNLOAD_ACTIVITY_ID = 80001;
    public static final int DOWNLOAD_COMPLETED_OK = 2;
    public static final int DOWNLOAD_FAILED = 4;
    public static final int DOWNLOAD_FILES_PRESENT = 1;
    public static final int DOWNLOAD_INVALID = 5;
    public static final int DOWNLOAD_NO_PLAY_KEY = 6;
    public static final int DOWNLOAD_NO_RETURN_CODE = 0;
    public static final String DOWNLOAD_RETURN_NAME = "Result";
    public static final int DOWNLOAD_USER_QUIT = 3;
    private static final DeviceInfoData[] DeviceInfoList;
    private static final int GOOGLE_SERVICES_REQUEST_RESOLVE_ERROR = 1001;
    private static final int MemoryAdvisorPollDelayMs = 100;
    private static final int PLAY_SERVICES_DIALOG_ID = 1;
    private static final int ProcessMemoryInfoPollDelayMs = 10000;
    static final float SampleDecayRate = 0.85f;
    private static Handler _UIHandler = null;
    private static Activity _activity = null;
    static Bundle _bundle = null;
    private static Context _context = null;
    static Bundle _extrasBundle = null;
    private static GameActivity _singleton = null;
    private static PowerManager.OnThermalStatusChangedListener _thermalStatusChangedListener = null;
    private static Context _this = null;
    public static final int checkLastVirtualKeyboardCommandDelay = 500;
    static boolean first_acceleration_sample = true;
    public static final int lastVirtualKeyboardCommandDelay = 200;
    private AssetManager AssetManagerReference;
    private String BuildConfiguration;
    private String[] CachedQueryProductIDs;
    public ArrayList<String> CommandLineArguments;
    public HashMap<String, String> CommandLineFlags;
    public String CommandLineFull;
    private String ConfigRulesStatus;
    private EAlertDialogType CurrentDialogType;
    int DepthBufferPreference;
    private int DesiredHolderHeight;
    private int DesiredHolderWidth;
    private String EGLErrorStatus;
    String EngineBranch;
    public String ExternalFilesDir;
    private String ForceExitCaption;
    private String ForceExitContinueButtonText;
    private String ForceExitHelpButtonText;
    private String ForceExitLink;
    private String ForceExitMessage;
    private String ForceExitQuitButtonText;
    private String ForceExitUpdateButtonText;
    private AlertDialog ForceGameDialog;
    private boolean HasAllFiles;
    private StoreHelper IapStoreHelper;
    private boolean InitCompletedOK;
    public String InternalFilesDir;
    private boolean IsForDistribution;
    private boolean IsInVRMode;
    private long LastMemoryInfoPollTime;
    private MemoryAdvisor MemAdvisor;
    private MemoryAdvisor.MemoryState MemState;
    private SurfaceView MySurfaceView;
    private int NumTimesScreenCaptureDisabled;
    public String OpenGLDevice;
    public String OpenGLDriver;
    public String OpenGLVendor;
    public String OpenGLVersion;
    private final int PermissionRequestCode;
    String ProjectVersion;
    private boolean PublicLogFiles;
    private boolean ShouldHideUI;
    private boolean SplashScreenLaunch;
    public String TextureFormats;
    private boolean UseDisplayCutout;
    private boolean UseExternalFilesDir;
    public int UsedMemory;
    public boolean VerifyOBBOnStartUp;
    public int VersionCode;
    private int VulkanLevel;
    private int VulkanVersion;
    private String VulkanVersionString;
    private boolean _bCreateView;
    private Map<String, String> _cpuInfo;
    private int _onCreateCallings;
    private Sensor accelerometer;
    LinearLayout activityLayout;
    private boolean bAllowIMU;
    private boolean bConfigRulesError;
    private boolean bForceGameEndWithError;
    private boolean bForceGameEndWithWarning;
    private boolean bHaveParsedCommandline;
    private boolean bKeepScreenOn;
    private boolean bKeyboardShowing;
    boolean bSensorDataUpdated;
    public boolean bSupportsFloatingPointRenderTargets;
    private boolean bSupportsVulkan;
    private boolean bUseSurfaceView;
    private boolean bUsesVrKeyboard;
    AlertDialog consoleAlert;
    LinearLayout consoleAlertLayout;
    ConsoleCmdReceiver consoleCmdReceiver;
    float consoleDistance;
    int consoleHistoryIndex;
    ArrayList<String> consoleHistoryList;
    EditText consoleInputBox;
    Spinner consoleSpinner;
    float consoleVelocity;
    private FrameLayout containerFrameLayout;
    float[] current_tilt;
    private Sensor gyroscope;
    private boolean localNotificationAppLaunched;
    private String localNotificationLaunchActivationEvent;
    private int localNotificationLaunchFireDate;
    private DownloadShimInterface mDownloadShimInterface;
    protected ProgressDialog mProgressDialog;
    private Handler mRestoreImmersiveModeHandler;
    protected Dialog mSplashDialog;
    private Sensor magnetometer;
    private View mainDecorView;
    private Rect mainDecorViewRect;
    private View mainView;
    private Handler memoryHandler;
    private HandlerThread memoryHandlerThread;
    private Runnable memoryRunnable;
    private com.epicgames.ue4.demonetwork.a networkStateChangedObserver;
    VirtualKeyboardInput newVirtualKeyboardInput;
    private int noActionAnimID;
    private final float[] orientationAngles;
    private Runnable restoreImmersiveModeRunnable;
    private final float[] rotationMatrix;
    private Rect safezone;
    private RectF safezoneF;
    private long sensorCbTimes;
    private long sensorCbTimestamp;
    private SensorManager sensorManager;
    AlertDialog virtualKeyboardAlert;
    private Handler virtualKeyboardHandler;
    EditText virtualKeyboardInputBox;
    String virtualKeyboardInputContent;
    int virtualKeyboardInputType;
    private LinearLayout virtualKeyboardLayout;
    String virtualKeyboardPreviousContents;
    static float[] current_accelerometer = {0.0f, 0.0f, 0.0f};
    static float[] current_gyroscope = {0.0f, 0.0f, 0.0f};
    static float[] current_magnetometer = {0.0f, 0.0f, 0.0f};
    static float[] filtered_gravity = {0.0f, 0.0f, 0.0f};
    static float[] last_gravity = {0.0f, 0.0f, 0.0f};
    static float[] last_tilt = {0.0f, 0.0f, 0.0f};
    static float[] current_rotation_rate = {0.0f, 0.0f, 0.0f};
    static float[] current_gravity = {0.0f, 0.0f, 0.0f};
    static float[] current_acceleration = {0.0f, 0.0f, 0.0f};
    public static Logger Log = new Logger("UE4", "GameActivity");
    public static VirtualKeyboardCommand lastVirtualKeyboardCommand = VirtualKeyboardCommand.VK_CMD_NONE;
    public static final boolean bSamsungDevice = Build.MANUFACTURER.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING);
    private static final String[] CONSOLE_SPINNER_ITEMS = {"Common Console Commands", "stat FPS", "stat Anim", "stat OpenGLRHI", "stat VulkanRHI", "stat DumpEvents", "stat DumpFrame", "stat DumpHitches", "stat Engine", "stat Game", "stat Grouped", "stat Hitches", "stat InitViews", "stat LightRendering", "stat Memory", "stat Particles", "stat SceneRendering", "stat SceneUpdate", "stat ShadowRendering", "stat Slow", "stat Streaming", "stat StreamingDetails", "stat Unit", "stat UnitGraph", "stat StartFile", "stat StopFile", "GameVer", "show PostProcessing", "stat AndroidCPU", "r.CMShowUROEnable 0", "r.CMShowUROEnable 1", "a.URO.Draw 0", "a.URO.Draw 1", "stat RHI"};
    private static int PackageDataInsideApkValue = -1;
    private static int HasOBBFiles = -1;
    private static String appPackageName = "";
    public static boolean bSupportedDevice = true;
    public static final int ANDROID_BUILD_VERSION = Build.VERSION.SDK_INT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.epicgames.ue4.GameActivity$49, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass49 {
        static final /* synthetic */ int[] $SwitchMap$com$epicgames$ue4$GameActivity$EAlertDialogType;
        static final /* synthetic */ int[] $SwitchMap$com$epicgames$ue4$GameActivity$VirtualKeyboardCommand;
        static final /* synthetic */ int[] $SwitchMap$com$google$android$apps$internal$games$memoryadvice$MemoryAdvisor$MemoryState;

        static {
            int[] iArr = new int[VirtualKeyboardCommand.values().length];
            $SwitchMap$com$epicgames$ue4$GameActivity$VirtualKeyboardCommand = iArr;
            try {
                iArr[VirtualKeyboardCommand.VK_CMD_SHOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$epicgames$ue4$GameActivity$VirtualKeyboardCommand[VirtualKeyboardCommand.VK_CMD_HIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[EAlertDialogType.values().length];
            $SwitchMap$com$epicgames$ue4$GameActivity$EAlertDialogType = iArr2;
            try {
                iArr2[EAlertDialogType.Keyboard.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$epicgames$ue4$GameActivity$EAlertDialogType[EAlertDialogType.Console.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[MemoryAdvisor.MemoryState.values().length];
            $SwitchMap$com$google$android$apps$internal$games$memoryadvice$MemoryAdvisor$MemoryState = iArr3;
            try {
                iArr3[MemoryAdvisor.MemoryState.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$android$apps$internal$games$memoryadvice$MemoryAdvisor$MemoryState[MemoryAdvisor.MemoryState.OK.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$android$apps$internal$games$memoryadvice$MemoryAdvisor$MemoryState[MemoryAdvisor.MemoryState.APPROACHING_LIMIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$android$apps$internal$games$memoryadvice$MemoryAdvisor$MemoryState[MemoryAdvisor.MemoryState.CRITICAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class DeviceInfoData {
        public final String name;
        public final int productId;
        public final int vendorId;

        DeviceInfoData(int i3, int i16, String str) {
            this.vendorId = i3;
            this.productId = i16;
            this.name = str;
        }

        boolean IsMatch(int i3, int i16) {
            if (this.vendorId == i3 && this.productId == i16) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface DownloadShimInterface {
        boolean expansionFilesDelivered(Activity activity, int i3);

        Class<Activity> getDownloaderType();
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    enum EAlertDialogType {
        None,
        Console,
        Keyboard
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum EDeviceOrientationType {
        Portrait,
        ReversePortrait,
        SensorPortrait,
        Landscape,
        ReverseLandscape,
        SensorLandscape,
        Sensor,
        FullSensor
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class InputDeviceInfo {
        public int controllerId;
        public String descriptor;
        public int deviceId;
        public String name;
        public int productId;
        public int vendorId;

        InputDeviceInfo(int i3, int i16, int i17, int i18, String str, String str2) {
            this.deviceId = i3;
            this.vendorId = i16;
            this.productId = i17;
            this.controllerId = i18;
            this.name = str;
            this.descriptor = str2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class LaunchNotification {
        public String event;
        public int fireDate;
        public boolean used;

        LaunchNotification(boolean z16, String str, int i3) {
            this.used = z16;
            this.event = str;
            this.fireDate = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private class VibrateRunnable implements Runnable {
        private int duration;
        private Vibrator vibrator;

        VibrateRunnable(int i3, Vibrator vibrator) {
            this.duration = i3;
            this.vibrator = vibrator;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3 = this.duration;
            if (i3 < 1) {
                this.vibrator.cancel();
            } else {
                this.vibrator.vibrate(i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum VirtualKeyboardCommand {
        VK_CMD_NONE,
        VK_CMD_SHOW,
        VK_CMD_HIDE
    }

    static {
        loadPluginByReflection("gcloud");
        loadPluginByReflection("GVoice");
        DeviceInfoList = new DeviceInfoData[]{new DeviceInfoData(1256, 40960, "Samsung Game Pad EI-GP20"), new DeviceInfoData(2389, 29187, "NVIDIA Corporation NVIDIA Controller v01.01"), new DeviceInfoData(2389, 29200, "NVIDIA Corporation NVIDIA Controller v01.03"), new DeviceInfoData(6473, 1028, "Amazon Fire TV Remote"), new DeviceInfoData(6473, 1030, "Amazon Fire Game Controller"), new DeviceInfoData(1848, 21091, "Mad Catz C.T.R.L.R (Smart)"), new DeviceInfoData(1848, 21094, "Mad Catz C.T.R.L.R"), new DeviceInfoData(1118, 654, "Xbox Wired Controller"), new DeviceInfoData(1118, com.tencent.luggage.wxa.wh.b.CTRL_INDEX, "Xbox Wireless Controller"), new DeviceInfoData(273, 5145, "SteelSeries Stratus XL"), new DeviceInfoData(1356, 1476, "PS4 Wireless Controller"), new DeviceInfoData(1356, 2508, "PS4 Wireless Controller (v2)"), new DeviceInfoData(1452, 1386, "glap QXPGP001"), new DeviceInfoData(gdt_analysis_event.EVENT_GET_VERSION_RELEASE_OR_CODENAME, 22352, "STMicroelectronics Lenovo GamePad"), new DeviceInfoData(5426, 1797, "Razer Razer Claire T1 Wired")};
        if (!UE4.isLibrariesLoaded()) {
            UE4.loadLibraries(false, true);
        }
    }

    public GameActivity(Context context) {
        super(context);
        this._bCreateView = true;
        this._onCreateCallings = 0;
        this.VersionCode = 0;
        this.bAllowIMU = true;
        this.safezone = new Rect(0, 0, 0, 0);
        this.safezoneF = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.rotationMatrix = new float[9];
        this.orientationAngles = new float[3];
        this.bSensorDataUpdated = false;
        this.current_tilt = new float[]{0.0f, 0.0f, 0.0f};
        this.noActionAnimID = -1;
        this.bHaveParsedCommandline = false;
        this.CommandLineFull = "";
        this.CommandLineArguments = new ArrayList<>();
        this.CommandLineFlags = new HashMap<>();
        this.EngineBranch = "UE4";
        this.ProjectVersion = "1.0.0";
        this.bKeepScreenOn = false;
        this.NumTimesScreenCaptureDisabled = 0;
        this.DepthBufferPreference = 0;
        this.HasAllFiles = false;
        this.VerifyOBBOnStartUp = false;
        this.UseExternalFilesDir = false;
        this.PublicLogFiles = false;
        this.InitCompletedOK = false;
        this.bConfigRulesError = false;
        this.ConfigRulesStatus = "UNSET";
        this.ForceGameDialog = null;
        this.bForceGameEndWithError = false;
        this.bForceGameEndWithWarning = false;
        this.ForceExitCaption = "";
        this.ForceExitMessage = "";
        this.ForceExitQuitButtonText = "";
        this.ForceExitHelpButtonText = "";
        this.ForceExitContinueButtonText = "";
        this.ForceExitUpdateButtonText = "";
        this.ForceExitLink = "";
        this.SplashScreenLaunch = false;
        this.UseDisplayCutout = false;
        this.ShouldHideUI = true;
        this.IsForDistribution = false;
        this.BuildConfiguration = "";
        this.IsInVRMode = false;
        this.bUsesVrKeyboard = false;
        this.bUseSurfaceView = false;
        this.DesiredHolderWidth = 0;
        this.DesiredHolderHeight = 0;
        this.VulkanVersion = 0;
        this.VulkanLevel = 0;
        this.VulkanVersionString = AEResManagerConfigBean.DEFAULT_VERSION;
        this.bSupportsVulkan = false;
        this.OpenGLVendor = "";
        this.OpenGLDevice = "";
        this.OpenGLVersion = "";
        this.OpenGLDriver = "";
        this.TextureFormats = "ETC1";
        this.bSupportsFloatingPointRenderTargets = false;
        this.EGLErrorStatus = "UNSET";
        this.localNotificationAppLaunched = false;
        this.localNotificationLaunchActivationEvent = "";
        this.localNotificationLaunchFireDate = 0;
        this.CurrentDialogType = EAlertDialogType.None;
        this.MemState = MemoryAdvisor.MemoryState.OK;
        this.PermissionRequestCode = 100;
        this.networkStateChangedObserver = null;
        this._cpuInfo = null;
        this.mRestoreImmersiveModeHandler = new Handler(Looper.getMainLooper());
        this.restoreImmersiveModeRunnable = new Runnable() { // from class: com.epicgames.ue4.GameActivity.14
            @Override // java.lang.Runnable
            public void run() {
                GameActivity.this.restoreTransparentBars();
            }
        };
        this.sensorCbTimes = 0L;
        this.sensorCbTimestamp = 0L;
        setContext(context);
    }

    public static void AndroidThunkJava_CMShowLog(int i3, String str) {
        GameActivityThunk.GetSingleton().CMShowLog(i3, str);
    }

    public static String AndroidThunkJava_GetFontDirectory() {
        String str;
        String[] strArr = {"/system/fonts", "/system/font", "/data/fonts"};
        int i3 = 0;
        while (true) {
            if (i3 < 3) {
                str = strArr[i3];
                if (new File(str).exists()) {
                    break;
                }
                i3++;
            } else {
                str = null;
                break;
            }
        }
        return str + "/";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean AndroidThunkJava_isIntentActionAvailable(String str) {
        List<ResolveInfo> queryIntentActivities = InstalledAppListMonitor.queryIntentActivities(getPackageManager(), new Intent(str, (Uri) null), 65536);
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            return true;
        }
        return false;
    }

    private void CheckKeyboardDisplayed() {
        this.virtualKeyboardHandler.postDelayed(new Runnable() { // from class: com.epicgames.ue4.GameActivity.33
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    if (GameActivity._activity != null && GameActivity.this.mainView != null) {
                        GameActivity gameActivity = GameActivity.this;
                        if (gameActivity.newVirtualKeyboardInput != null) {
                            if (gameActivity.bKeyboardShowing && GameActivity.this.newVirtualKeyboardInput.getY() < 0.0f) {
                                GameActivity.this.mainView.requestLayout();
                            }
                        }
                    }
                }
            }
        }, 500L);
    }

    public static GameActivityBase CreateSingleton(Context context) {
        GameActivity gameActivity = _singleton;
        if (gameActivity != null) {
            return gameActivity;
        }
        _singleton = new GameActivity(context);
        _UIHandler = new Handler(Looper.getMainLooper());
        return _singleton;
    }

    /* JADX WARN: Removed duplicated region for block: B:179:0x00b8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean EvaluateConditions(Map<String, String> map, ArrayList<String> arrayList, String str) {
        String str2;
        boolean z16;
        float f16;
        Iterator<String> it = arrayList.iterator();
        while (true) {
            int i3 = 1;
            if (!it.hasNext()) {
                return true;
            }
            Iterator<String> it5 = ParseSegments(RemoveSurrounds(it.next(), "(", ")"), ",", "\"", "\"").iterator();
            String str3 = "";
            String str4 = "";
            String str5 = str4;
            while (it5.hasNext()) {
                ArrayList<String> ParseSegments = ParseSegments(it5.next(), ContainerUtils.KEY_VALUE_DELIMITER, "\"", "\"");
                if (ParseSegments.size() == 2) {
                    String RemoveSurrounds = RemoveSurrounds(ParseSegments.get(0), "\"", "\"");
                    String RemoveSurrounds2 = RemoveSurrounds(ParseSegments.get(1), "\"", "\"");
                    if (RemoveSurrounds.equals("SourceType")) {
                        str3 = RemoveSurrounds2;
                    } else if (RemoveSurrounds.equals("CompareType")) {
                        str5 = RemoveSurrounds2;
                    } else if (RemoveSurrounds.equals("MatchString")) {
                        str4 = RemoveSurrounds2;
                    }
                }
            }
            if (str3.equals("SRC_PreviousRegexMatch")) {
                str2 = str;
            } else if (str3.equals("SRC_CommandLine")) {
                str2 = this.CommandLineFull;
                z16 = true;
                if (!str5.equals("CMP_Exist")) {
                    if (!map.containsKey(str2)) {
                        break;
                    }
                } else if (str5.equals("CMP_NotExist")) {
                    if (map.containsKey(str2)) {
                        break;
                    }
                } else if (str5.equals("CMP_Equal")) {
                    if (z16) {
                        if (!this.CommandLineFlags.containsKey(str4)) {
                            break;
                        }
                    } else if (!str2.equals(str4)) {
                        break;
                    }
                } else if (str5.equals("CMP_NotEqual")) {
                    if (z16) {
                        if (this.CommandLineFlags.containsKey(str4)) {
                            break;
                        }
                    } else if (str2.equals(str4)) {
                        break;
                    }
                } else if (str5.equals("CMP_EqualIgnore")) {
                    if (!str2.toLowerCase().equals(str4.toLowerCase())) {
                        break;
                    }
                } else if (str5.equals("CMP_NotEqualIgnore")) {
                    if (str2.toLowerCase().equals(str4.toLowerCase())) {
                        break;
                    }
                } else if (str5.equals("CMP_Regex")) {
                    Matcher matcher = Pattern.compile(str4).matcher(str2);
                    if (!matcher.find()) {
                        break;
                    }
                    if (matcher.groupCount() < 1) {
                        i3 = 0;
                    }
                    str = matcher.group(i3);
                } else {
                    float f17 = 0.0f;
                    try {
                        f16 = Float.parseFloat(str2);
                    } catch (NumberFormatException unused) {
                        f16 = 0.0f;
                        i3 = 0;
                    }
                    try {
                        f17 = Float.parseFloat(str4);
                    } catch (NumberFormatException unused2) {
                        i3 = 0;
                    }
                    if (str5.endsWith("Ignore")) {
                        str5 = str5.substring(0, str5.length() - 6);
                        str2 = str2.toLowerCase();
                        str4 = str4.toLowerCase();
                        i3 = 0;
                    }
                    if (!str5.equals("CMP_Less")) {
                        break;
                    }
                    break;
                }
            } else if (map.containsKey(str3)) {
                str2 = map.get(str3);
            } else {
                if (!str3.equals("[EXIST]")) {
                    break;
                }
                str2 = str4;
            }
            z16 = false;
            if (!str5.equals("CMP_Exist")) {
            }
        }
        return false;
    }

    private String ExpandVariables(Map<String, String> map, String str) {
        int i3;
        int indexOf;
        int indexOf2 = str.indexOf("$(");
        while (indexOf2 != -1 && (indexOf = str.indexOf(41, (i3 = indexOf2 + 2))) != -1) {
            String substring = str.substring(i3, indexOf);
            if (!map.containsKey(substring)) {
                indexOf2 = indexOf + 1;
            } else {
                str = str.substring(0, indexOf2) + map.get(substring) + str.substring(indexOf + 1);
            }
            indexOf2 = str.indexOf("$(", indexOf2);
        }
        return str;
    }

    private void GCloudSDKRequestDynamicPermissions() {
        RequestPermission(_activity, new ArrayList(), 100);
    }

    public static GameActivity Get() {
        return _singleton;
    }

    @TargetApi(23)
    private String GetAccessToken() {
        return "";
    }

    public static GameActivity GetSingleton() {
        return _singleton;
    }

    private void InitNetStateChangeObserve() {
        Log.debug("GameActivityDemo regist network change receive");
        this.networkStateChangedObserver = new com.epicgames.ue4.demonetwork.a() { // from class: com.epicgames.ue4.GameActivity.1
            @Override // com.epicgames.ue4.demonetwork.a
            public void onNetConnected(NetworkType networkType) {
                GameActivity.Log.debug("GameActivityDemo onNetworkAvailable");
                UE4.OnCMShowNetworkStateChanged(1);
                GameActivity.Log.debug("GameActivityDemo onNetworkAvailable end");
            }

            @Override // com.epicgames.ue4.demonetwork.a
            public void onNetDisconnected() {
                GameActivity.Log.debug("GameActivityDemo onNetworkLost");
                UE4.OnCMShowNetworkStateChanged(0);
            }
        };
        NetStateChangeReceiver.c(this);
        NetStateChangeReceiver.b(this.networkStateChangedObserver);
    }

    private void LocalNotificationCheckAppOpen() {
        Intent intent;
        this.localNotificationAppLaunched = false;
        this.localNotificationLaunchActivationEvent = "";
        this.localNotificationLaunchFireDate = 0;
        Activity activity = _activity;
        if (activity != null && (intent = activity.getIntent()) != null) {
            Bundle extras = intent.getExtras();
            boolean booleanExtra = intent.getBooleanExtra("localNotificationAppLaunched", false);
            this.localNotificationAppLaunched = booleanExtra;
            if (booleanExtra) {
                String string = extras.getString("localNotificationLaunchActivationEvent");
                this.localNotificationLaunchActivationEvent = string;
                if (string != null) {
                    LocalNotificationRemoveID(this, extras.getInt("localNotificationID"));
                    this.localNotificationLaunchFireDate = 0;
                } else {
                    this.localNotificationAppLaunched = false;
                    this.localNotificationLaunchActivationEvent = "";
                }
            }
        }
    }

    public static int LocalNotificationGetID(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LocalNotificationPreferences", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        String string = sharedPreferences.getString("notificationIDs", "");
        int i3 = 1;
        if (string.length() == 0) {
            edit.putString("notificationIDs", Integer.toString(1));
        } else {
            String[] split = string.split("-");
            ArrayList arrayList = new ArrayList();
            for (String str : split) {
                if (str.length() > 0) {
                    arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                }
            }
            while (arrayList.contains(Integer.valueOf(i3))) {
                i3++;
            }
            edit.putString("notificationIDs", string + "-" + i3);
        }
        edit.commit();
        return i3;
    }

    private ArrayList<Integer> LocalNotificationGetIDList() {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("LocalNotificationPreferences", 0);
        sharedPreferences.edit();
        String string = sharedPreferences.getString("notificationIDs", "");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (String str : string.split("-")) {
            if (str.length() > 0) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str)));
            }
        }
        return arrayList;
    }

    private boolean LocalNotificationIDExists(int i3) {
        if (i3 == -1) {
            return false;
        }
        Iterator<Integer> it = LocalNotificationGetIDList().iterator();
        while (it.hasNext()) {
            if (it.next().intValue() == i3) {
                return true;
            }
        }
        return false;
    }

    public static void LocalNotificationRemoveDetails(Context context, int i3) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LocalNotificationPreferences", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        try {
            JSONObject jSONObject = new JSONObject(sharedPreferences.getString("notificationDetails", "{}"));
            jSONObject.remove(String.valueOf(i3));
            edit.putString("notificationDetails", jSONObject.toString());
            edit.commit();
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public static void LocalNotificationRemoveID(Context context, int i3) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LocalNotificationPreferences", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        String str = "";
        String string = sharedPreferences.getString("notificationIDs", "");
        ArrayList arrayList = new ArrayList();
        if (string.length() == 0) {
            return;
        }
        for (String str2 : string.split("-")) {
            if (str2.length() > 0) {
                arrayList.add(str2);
            }
        }
        arrayList.remove(Integer.toString(i3));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            if (str.length() != 0) {
                str3 = str + "-" + str3;
            }
            str = str3;
        }
        edit.putString("notificationIDs", str);
        edit.commit();
    }

    public static boolean LocalNotificationScheduleAtTime(Context context, int i3, String str, boolean z16, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent(context, (Class<?>) LocalNotificationReceiver.class);
        intent.putExtra(LocalNotificationReceiver.KEY_LOCAL_NOTIFICATION_ID, i3);
        intent.putExtra(LocalNotificationReceiver.KEY_LOCAL_NOTIFICATION_TITLE, str2);
        intent.putExtra(LocalNotificationReceiver.KEY_LOCAL_NOTIFICATION_BODY, str3);
        intent.putExtra(LocalNotificationReceiver.KEY_LOCAL_NOTIFICATION_ACTION, str4);
        intent.putExtra(LocalNotificationReceiver.KEY_LOCAL_NOTIFICATION_ACTION_EVENT, str5);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, i3, intent, 134217728);
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        if (z16) {
            timeZone = TimeZone.getDefault();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(timeZone);
        new Date();
        try {
            Date parse = simpleDateFormat.parse(str);
            long time = parse.getTime() - new Date().getTime();
            if (time < 0) {
                LocalNotificationRemoveID(context, i3);
                return false;
            }
            ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(2, SystemClock.elapsedRealtime() + time, broadcast);
            return true;
        } catch (ParseException e16) {
            e16.printStackTrace();
            LocalNotificationRemoveID(context, i3);
            return false;
        }
    }

    private ArrayList<String> ParseSegments(String str, String str2, String str3, String str4) {
        int indexOf;
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        int length = str.length();
        int i3 = 0;
        int i16 = 0;
        int i17 = -1;
        while (i3 < length) {
            int i18 = i3 + 1;
            String substring = str.substring(i3, i18);
            if (substring.equals(str2) && arrayList2.size() == 0) {
                arrayList.add(str.substring(i16, i3).trim());
                i3 = i18;
                i16 = i3;
            } else if (substring.equals("\\")) {
                i3 = i18 + 1;
            } else if (arrayList2.size() > 0 && str4.indexOf(substring) == i17) {
                int size = arrayList2.size() - 1;
                arrayList2.remove(size);
                if (size > 0) {
                    indexOf = ((Integer) arrayList2.get(size - 1)).intValue();
                    i17 = indexOf;
                    i3 = i18;
                } else {
                    i17 = -1;
                    i3 = i18;
                }
            } else {
                indexOf = str3.indexOf(substring);
                if (indexOf >= 0) {
                    arrayList2.add(Integer.valueOf(indexOf));
                    i17 = indexOf;
                }
                i3 = i18;
            }
        }
        if (i16 < length) {
            arrayList.add(str.substring(i16).trim());
        }
        return arrayList;
    }

    private String RemoveSurrounds(String str, String str2, String str3) {
        int length = str2.length();
        int length2 = str3.length();
        int length3 = str.length();
        if (length3 >= 2 && length > 0 && length == length2) {
            int i3 = 0;
            String substring = str.substring(0, 1);
            int i16 = length3 - 1;
            String substring2 = str.substring(i16);
            while (i3 < length) {
                int i17 = i3 + 1;
                if (str2.substring(i3, i17).equals(substring) && str3.substring(i3, i17).equals(substring2)) {
                    return str.substring(1, i16);
                }
                i3 = i17;
            }
        }
        return str;
    }

    private void RequestPermission(Activity activity, List<String> list, int i3) {
        if (activity != null && list != null) {
            ArrayList arrayList = new ArrayList();
            for (int i16 = 0; i16 < list.size(); i16++) {
                String str = list.get(i16);
                if (str != null && ContextCompat.checkSelfPermission(activity.getApplicationContext(), str) != 0) {
                    arrayList.add(str);
                }
            }
            if (arrayList.size() > 0) {
                ActivityCompat.requestPermissions(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RestartApplication(String str) {
        Context applicationContext = getApplicationContext();
        Intent launchIntentForPackage = InstalledAppListMonitor.getLaunchIntentForPackage(applicationContext.getPackageManager(), applicationContext.getPackageName());
        launchIntentForPackage.addFlags(335577088);
        launchIntentForPackage.putExtra("RestartExtra", str);
        applicationContext.startActivity(launchIntentForPackage);
        Runtime.getRuntime().exit(0);
    }

    private void SetDisableScreenCaptureInternal(boolean z16) {
        Activity activity = _activity;
        if (activity == null) {
            return;
        }
        if (z16) {
            activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.25
                @Override // java.lang.Runnable
                public void run() {
                    if (GameActivity._activity == null) {
                        return;
                    }
                    GameActivity.Log.debug("==============> [JAVA] AndroidThunkJava_DisableScreenCapture(true) - Disabled screen captures");
                    GameActivity._activity.getWindow().addFlags(8192);
                }
            });
        } else {
            activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.26
                @Override // java.lang.Runnable
                public void run() {
                    if (GameActivity._activity == null) {
                        return;
                    }
                    GameActivity.Log.debug("==============> [JAVA] AndroidThunkJava_DisableScreenCapture(false) - Enabled screen captures");
                    GameActivity._activity.getWindow().clearFlags(8192);
                }
            });
        }
    }

    private BufferedReader TryOpenFileReader(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            return new BufferedReader(new FileReader(file));
        } catch (IOException unused) {
            return null;
        }
    }

    private void createVirtualKeyboardInput() {
        Activity activity = _activity;
        if (activity != null) {
            activity.getWindow().setSoftInputMode(16);
        }
        VirtualKeyboardInput virtualKeyboardInput = new VirtualKeyboardInput(_this);
        this.newVirtualKeyboardInput = virtualKeyboardInput;
        virtualKeyboardInput.setSingleLine(false);
        this.newVirtualKeyboardInput.setBackgroundColor(-1);
        this.newVirtualKeyboardInput.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        this.newVirtualKeyboardInput.setVisibility(8);
        if (ANDROID_BUILD_VERSION < 11) {
            this.newVirtualKeyboardInput.setImeOptions(268435456);
        } else {
            this.newVirtualKeyboardInput.setImeOptions(301989888);
        }
        this.newVirtualKeyboardInput.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.epicgames.ue4.GameActivity.44
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                boolean z16;
                if ((i3 & 255) != 6) {
                    z16 = false;
                } else {
                    GameActivity.this.AndroidThunkJava_HideVirtualKeyboardInput();
                    GameActivity.this.nativeVirtualKeyboardSendKey(66);
                    z16 = true;
                }
                EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
                return z16;
            }
        });
        this.newVirtualKeyboardInput.addTextChangedListener(new TextWatcher() { // from class: com.epicgames.ue4.GameActivity.45
            private void downgradeEasyCorrectionSpans() {
                Editable text = GameActivity.this.newVirtualKeyboardInput.getText();
                if (text instanceof Spannable) {
                    SuggestionSpan[] suggestionSpanArr = (SuggestionSpan[]) text.getSpans(0, text.length(), SuggestionSpan.class);
                    for (int i3 = 0; i3 < suggestionSpanArr.length; i3++) {
                        int flags = suggestionSpanArr[i3].getFlags();
                        if ((flags & 1) != 0 && (flags & 2) == 0) {
                            suggestionSpanArr[i3].setFlags(flags & (-2));
                        }
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
                if (GameActivity.this.newVirtualKeyboardInput.getY() > 0.0f || GameActivity.this.bUsesVrKeyboard) {
                    if (charSequence.length() == 0) {
                        GameActivity.this.virtualKeyboardHandler.postDelayed(new Runnable() { // from class: com.epicgames.ue4.GameActivity.45.1
                            @Override // java.lang.Runnable
                            public void run() {
                                GameActivity.this.nativeVirtualKeyboardChanged(GameActivity.this.newVirtualKeyboardInput.getText().toString());
                            }
                        }, 100L);
                    } else {
                        GameActivity.this.virtualKeyboardHandler.postDelayed(new Runnable() { // from class: com.epicgames.ue4.GameActivity.45.2
                            @Override // java.lang.Runnable
                            public void run() {
                                String obj = GameActivity.this.newVirtualKeyboardInput.getText().toString();
                                if (GameActivity.this.newVirtualKeyboardInput.getMaxLines() == 1 && obj.contains("\n")) {
                                    obj = obj.replaceAll("\n", " ");
                                    GameActivity.this.newVirtualKeyboardInput.setText(obj);
                                }
                                GameActivity.this.nativeVirtualKeyboardChanged(obj);
                            }
                        }, 100L);
                    }
                }
                downgradeEasyCorrectionSpans();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }
        });
        LinearLayout linearLayout = this.virtualKeyboardLayout;
        if (linearLayout != null) {
            linearLayout.addView(this.newVirtualKeyboardInput);
        }
        if (this.virtualKeyboardHandler == null) {
            this.virtualKeyboardHandler = new Handler(Looper.getMainLooper());
        }
    }

    private boolean expansionFilesDelivered(Activity activity, int i3) {
        try {
            return ((Boolean) Class.forName("com.epicgames.ue4.DownloadShim").getMethod("expansionFilesDelivered", Activity.class, Integer.TYPE).invoke(null, activity, Integer.valueOf(i3))).booleanValue();
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
            return true;
        } catch (IllegalAccessException e17) {
            e17.printStackTrace();
            return true;
        } catch (NoSuchMethodException e18) {
            e18.printStackTrace();
            return true;
        } catch (InvocationTargetException e19) {
            e19.printStackTrace();
            return true;
        }
    }

    private SecretKey generateAESKey(String str) {
        byte[] bArr = {35, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, -45, -93, 48, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, 99, -29};
        try {
            return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(str.toCharArray(), bArr, 1000, 128)).getEncoded(), KeyPropertiesCompact.KEY_ALGORITHM_AES);
        } catch (Exception unused) {
            return new SecretKeySpec(bArr, KeyPropertiesCompact.KEY_ALGORITHM_AES);
        }
    }

    public static Activity getActivity() {
        return _activity;
    }

    public static String getAppPackageName() {
        return appPackageName;
    }

    private byte[] getByteArrayFromAssets(String str) {
        try {
            InputStream open = this.AssetManagerReference.open("configrules.bin.png");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            return bArr;
        } catch (FileNotFoundException | IOException unused) {
            return null;
        }
    }

    public static byte[] getByteArrayFromFile(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                byte[] bArr = new byte[(int) file.length()];
                FileInputStream fileInputStream = new FileInputStream(file);
                fileInputStream.read(bArr);
                fileInputStream.close();
                return bArr;
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    private InputStream getConfigRulesDecompressed(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length - 10) < 0) {
            return null;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (wrap.getShort() != 14808) {
            return null;
        }
        wrap.getInt();
        int i3 = wrap.getInt();
        byte[] bArr2 = new byte[i3];
        try {
            try {
                String str = (String) getClass().getDeclaredField("CONFIGRULES_KEY").get(this);
                Cipher cipher = Cipher.getInstance(KeyPropertiesCompact.KEY_ALGORITHM_AES);
                cipher.init(2, generateAESKey(str));
                byte[] doFinal = cipher.doFinal(bArr, 10, length);
                length = doFinal.length;
                Inflater inflater = new Inflater();
                inflater.setInput(doFinal, 0, length);
                int inflate = inflater.inflate(bArr2);
                inflater.end();
                if (inflate != i3) {
                    return null;
                }
            } catch (Exception unused) {
                Inflater inflater2 = new Inflater();
                inflater2.setInput(bArr, 10, length);
                int inflate2 = inflater2.inflate(bArr2);
                inflater2.end();
                if (inflate2 != i3) {
                    return null;
                }
            }
            return new ByteArrayInputStream(bArr2);
        } catch (Exception unused2) {
            return null;
        }
    }

    private InputStream getConfigRulesStream(String str) {
        InputStream configRulesDecompressed;
        if (this.InternalFilesDir == null) {
            return null;
        }
        this.ConfigRulesStatus = "";
        byte[] byteArrayFromAssets = getByteArrayFromAssets("configrules.bin.png");
        byte[] byteArrayFromFile = getByteArrayFromFile(this.InternalFilesDir + "configrules.bin.png");
        byte[] byteArrayFromFile2 = getByteArrayFromFile(Environment.getExternalStorageDirectory().getAbsolutePath() + "/UE4Game/" + str + "/configrules.bin.png");
        int configRulesVersion = getConfigRulesVersion(byteArrayFromAssets);
        int configRulesVersion2 = getConfigRulesVersion(byteArrayFromFile);
        int configRulesVersion3 = getConfigRulesVersion(byteArrayFromFile2);
        if (configRulesVersion == -1 && configRulesVersion2 == -1 && configRulesVersion3 == -1) {
            this.ConfigRulesStatus = "Not found. ";
            return null;
        }
        if (this.CommandLineFlags.containsKey("noconfigrulesdownload")) {
            configRulesDecompressed = getConfigRulesDecompressed(byteArrayFromAssets);
        } else if (configRulesVersion >= configRulesVersion2 && configRulesVersion >= configRulesVersion3) {
            configRulesDecompressed = getConfigRulesDecompressed(byteArrayFromAssets);
        } else if (configRulesVersion2 >= configRulesVersion && configRulesVersion2 >= configRulesVersion3) {
            configRulesDecompressed = getConfigRulesDecompressed(byteArrayFromFile);
            if (configRulesDecompressed == null && configRulesVersion != -1) {
                configRulesDecompressed = getConfigRulesDecompressed(byteArrayFromAssets);
            }
        } else {
            configRulesDecompressed = getConfigRulesDecompressed(byteArrayFromFile2);
            if (configRulesDecompressed == null && configRulesVersion2 != -1) {
                configRulesDecompressed = getConfigRulesDecompressed(byteArrayFromFile);
            }
            if (configRulesDecompressed == null && configRulesVersion != -1) {
                configRulesDecompressed = getConfigRulesDecompressed(byteArrayFromAssets);
            }
        }
        if (configRulesDecompressed == null) {
            this.ConfigRulesStatus = "failed to find config rules. ";
            this.bConfigRulesError = true;
        }
        return configRulesDecompressed;
    }

    private int getConfigRulesVersion(byte[] bArr) {
        if (bArr == null || bArr.length - 10 < 0) {
            return -1;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (wrap.getShort() != 14808) {
            return -1;
        }
        return wrap.getInt();
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Map<String, String> getCpuInfo() {
        BufferedReader bufferedReader;
        String str;
        Map<String, String> map = this._cpuInfo;
        if (map == null) {
            map = new HashMap<>();
            this._cpuInfo = map;
            File file = new File("/proc/cpuinfo");
            if (file.exists()) {
                BufferedReader bufferedReader2 = null;
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    int i3 = -1;
                    int i16 = 0;
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            if (readLine.length() > 1) {
                                String[] split = readLine.split(MsgSummary.STR_COLON);
                                if (split.length > 1) {
                                    split[0] = split[0].trim();
                                    split[1] = split[1].trim();
                                    if (split[0].equals("processor")) {
                                        try {
                                            i3 = Integer.parseInt(split[1]);
                                            if (i3 > i16) {
                                                i16 = i3;
                                            }
                                        } catch (NumberFormatException unused) {
                                        }
                                    } else {
                                        StringBuilder sb5 = new StringBuilder();
                                        if (i3 == -1) {
                                            str = "";
                                        } else {
                                            str = i3 + ":";
                                        }
                                        sb5.append(str);
                                        sb5.append(split[0]);
                                        map.put(sb5.toString(), split[1]);
                                    }
                                }
                            }
                            i3 = -1;
                        } catch (IOException e16) {
                            e = e16;
                            bufferedReader2 = bufferedReader;
                            Log.debug("failed to read /proc/cpuinfo: " + e);
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                            }
                            return map;
                        }
                    }
                    map.put("processorCount", Integer.toString(i16 + 1));
                } catch (IOException e17) {
                    e = e17;
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused2) {
                    }
                }
            } else {
                Log.debug("failed to open /proc/cpuinfo!");
            }
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object getDownloaderType() {
        try {
            return Class.forName("com.epicgames.ue4.DownloadShim").getMethod("GetDownloaderType", new Class[0]).invoke(null, null);
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
            return null;
        } catch (IllegalAccessException e17) {
            e17.printStackTrace();
            return null;
        } catch (NoSuchMethodException e18) {
            e18.printStackTrace();
            return null;
        } catch (InvocationTargetException e19) {
            e19.printStackTrace();
            return null;
        }
    }

    private void getGraphicsInformation() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        int eglGetError = EGL14.eglGetError();
        if (eglGetError == 12288) {
            str = "";
        } else {
            str = "InitialEGLError = " + eglGetError + " ";
        }
        this.EGLErrorStatus = str;
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.EGLErrorStatus);
        if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
            str2 = "";
        } else {
            str2 = "eglGetDisplay = " + EGL14.eglGetError() + " ";
        }
        sb5.append(str2);
        this.EGLErrorStatus = sb5.toString();
        int[] iArr = new int[2];
        boolean z16 = true;
        boolean eglInitialize = EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1);
        StringBuilder sb6 = new StringBuilder();
        sb6.append(this.EGLErrorStatus);
        if (eglInitialize) {
            str3 = "";
        } else {
            str3 = "eglInitialize = " + EGL14.eglGetError() + " ";
        }
        sb6.append(str3);
        this.EGLErrorStatus = sb6.toString();
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr2 = new int[1];
        EGL14.eglChooseConfig(eglGetDisplay, new int[]{12351, 12430, 12329, 0, 12352, 4, 12339, 1, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0);
        if (iArr2[0] == 0) {
            this.EGLErrorStatus += "eglChooseConfig = " + EGL14.eglGetError() + " ";
            Log.debug("Did not find an EGL config");
            return;
        }
        EGLConfig eGLConfig = eGLConfigArr[0];
        EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eglGetDisplay, eGLConfig, new int[]{MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, 8, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, 8, 12344}, 0);
        StringBuilder sb7 = new StringBuilder();
        sb7.append(this.EGLErrorStatus);
        if (eglCreatePbufferSurface != EGL14.EGL_NO_SURFACE) {
            str4 = "";
        } else {
            str4 = "eglCreatePbufferSurface = " + EGL14.eglGetError() + " ";
        }
        sb7.append(str4);
        this.EGLErrorStatus = sb7.toString();
        EGLContext eglCreateContext = EGL14.eglCreateContext(eglGetDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344}, 0);
        StringBuilder sb8 = new StringBuilder();
        sb8.append(this.EGLErrorStatus);
        if (eglCreateContext != EGL14.EGL_NO_CONTEXT) {
            str5 = "";
        } else {
            str5 = "eglCreateContext = " + EGL14.eglGetError() + " ";
        }
        sb8.append(str5);
        this.EGLErrorStatus = sb8.toString();
        boolean eglMakeCurrent = EGL14.eglMakeCurrent(eglGetDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext);
        StringBuilder sb9 = new StringBuilder();
        sb9.append(this.EGLErrorStatus);
        if (eglMakeCurrent) {
            str6 = "";
        } else {
            str6 = "eglMakeCurrent = " + EGL14.eglGetError() + " ";
        }
        sb9.append(str6);
        this.EGLErrorStatus = sb9.toString();
        String glGetString = GLES20.glGetString(7939);
        this.OpenGLVendor = GLES20.glGetString(7936);
        this.OpenGLDevice = GLES20.glGetString(7937);
        String glGetString2 = GLES20.glGetString(7938);
        this.OpenGLDriver = glGetString2;
        boolean contains = glGetString2.contains("OpenGL ES 3.");
        int glGetError = GLES20.glGetError();
        StringBuilder sb10 = new StringBuilder();
        sb10.append(this.EGLErrorStatus);
        if (glGetError == 0) {
            str7 = "getGraphicsInformation completed. ";
        } else {
            str7 = "gl error = " + glGetError;
        }
        sb10.append(str7);
        this.EGLErrorStatus = sb10.toString();
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent(eglGetDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
        EGL14.eglDestroySurface(eglGetDisplay, eglCreatePbufferSurface);
        EGL14.eglDestroyContext(eglGetDisplay, eglCreateContext);
        EGL14.eglTerminate(eglGetDisplay);
        this.OpenGLDevice.contains("NVIDIA");
        this.OpenGLDevice.contains("PowerVR");
        this.OpenGLDevice.contains("Adreno");
        this.OpenGLDevice.contains("Mali");
        this.OpenGLDevice.contains("VideoCore");
        this.OpenGLVersion = "";
        int indexOf = this.OpenGLDriver.indexOf("OpenGL ES ");
        if (indexOf >= 0) {
            String substring = this.OpenGLDriver.substring(indexOf + 10);
            this.OpenGLVersion = substring;
            int indexOf2 = substring.indexOf(" ");
            if (indexOf2 > 0) {
                this.OpenGLVersion = this.OpenGLVersion.substring(0, indexOf2);
            }
        }
        if (!glGetString.contains("GL_EXT_color_buffer_half_float") && (!contains || !glGetString.contains("GL_EXT_color_buffer_float"))) {
            z16 = false;
        }
        this.bSupportsFloatingPointRenderTargets = z16;
        this.TextureFormats = "";
        if (glGetString.contains("GL_KHR_texture_compression_astc_ldr")) {
            this.TextureFormats += "ASTC,";
        }
        if (glGetString.contains("GL_IMG_texture_compression_pvrtc")) {
            this.TextureFormats += "PVRTC,";
        }
        if (glGetString.contains("GL_NV_texture_compression_s3tc") || glGetString.contains("GL_EXT_texture_compression_s3tc")) {
            this.TextureFormats += "DXT,";
        }
        if (glGetString.contains("GL_ATI_texture_compression_atitc") || glGetString.contains("GL_AMD_compressed_ATC_texture")) {
            this.TextureFormats += "ATC,";
        }
        if (this.OpenGLVersion.charAt(0) >= '3') {
            this.TextureFormats += "ETC2,";
        }
        this.TextureFormats += "ETC1";
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<String> getInstalledPackages(Context context) {
        BufferedReader bufferedReader;
        Exception e16;
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<PackageInfo> it = InstalledAppListMonitor.getInstalledPackages(context.getPackageManager(), 0).iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().packageName);
            }
            return arrayList;
        } catch (Exception unused) {
            try {
                Process exec = RuntimeMonitor.exec(Runtime.getRuntime(), "pm list packages");
                bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        arrayList.add(readLine.substring(readLine.indexOf(58) + 1));
                    } catch (Exception e17) {
                        e16 = e17;
                        e16.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception unused2) {
                            }
                        }
                        return arrayList;
                    }
                }
                bufferedReader.close();
                exec.waitFor();
            } catch (Exception e18) {
                bufferedReader = null;
                e16 = e18;
            }
            if (bufferedReader != null) {
            }
            return arrayList;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String getProp(String str) {
        BufferedReader bufferedReader;
        Exception e16;
        Process process;
        String str2 = "";
        try {
            try {
                String str3 = (String) SystemProperties.class.getMethod("get", String.class).invoke(null, str);
                if (str3 == null) {
                    return "";
                }
                return str3;
            } catch (Exception unused) {
                process = new ProcessBuilder(new String[0]).command("/system/bin/getprop", str).redirectErrorStream(true).start();
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            str2 = readLine;
                        }
                    } catch (Exception e17) {
                        e16 = e17;
                        Log.debug("Unable to use getprop: " + e16);
                        if (bufferedReader != null) {
                        }
                        if (process != null) {
                        }
                        return str2;
                    }
                } catch (Exception e18) {
                    bufferedReader = null;
                    e16 = e18;
                }
                if (bufferedReader != null) {
                }
                if (process != null) {
                }
                return str2;
            }
        } catch (Exception e19) {
            bufferedReader = null;
            e16 = e19;
            process = null;
            Log.debug("Unable to use getprop: " + e16);
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused2) {
                }
            }
            if (process != null) {
                process.destroy();
            }
            return str2;
        }
    }

    private int getResourceId(String str, String str2, String str3) {
        try {
            return getResources().getIdentifier(str, str2, str3);
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    private String getResourceStringOrDefault(String str, String str2, String str3) {
        int resourceId = getResourceId(str2, HippyControllerProps.STRING, str);
        if (resourceId >= 1) {
            return getString(resourceId);
        }
        return str3;
    }

    @TargetApi(17)
    public static boolean isAirplaneModeOn(Context context) {
        if (Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) == 0) {
            return false;
        }
        return true;
    }

    public static boolean isOBBInAPK() {
        boolean z16;
        Logger logger = Log;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Asking if osOBBInAPK? ");
        if (PackageDataInsideApkValue == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        logger.debug(sb5.toString());
        if (PackageDataInsideApkValue != 1) {
            return false;
        }
        return true;
    }

    public static void loadPluginByReflection(String str) {
        try {
            int i3 = PluginUtils.f108394a;
            PluginUtils.class.getDeclaredMethod("loadLibrary", String.class).invoke(PluginUtils.class, str);
        } catch (Exception e16) {
            e16.printStackTrace();
            try {
                System.loadLibrary(str);
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
    }

    private void onDetachContext() {
        if (!UE4.hasOption(2) || _context == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29 && _thermalStatusChangedListener != null) {
            try {
                ((PowerManager) getApplicationContext().getSystemService("power")).removeThermalStatusListener(_thermalStatusChangedListener);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            _thermalStatusChangedListener = null;
        }
        VirtualKeyboardInput virtualKeyboardInput = this.newVirtualKeyboardInput;
        if (virtualKeyboardInput != null) {
            LinearLayout linearLayout = this.virtualKeyboardLayout;
            if (linearLayout != null) {
                linearLayout.removeView(virtualKeyboardInput);
            }
            this.newVirtualKeyboardInput = null;
        }
        FrameLayout frameLayout = this.containerFrameLayout;
        if (frameLayout != null) {
            LinearLayout linearLayout2 = this.virtualKeyboardLayout;
            if (linearLayout2 != null) {
                frameLayout.removeView(linearLayout2);
            }
            SurfaceView surfaceView = this.MySurfaceView;
            if (surfaceView != null) {
                this.containerFrameLayout.removeView(surfaceView);
            }
        }
        this.containerFrameLayout = null;
        this.virtualKeyboardLayout = null;
        this.MySurfaceView = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResumeBody() {
        boolean z16;
        int i3;
        UE4.profileBegin();
        acquireSensors();
        if (UE4.isDeviceOrientationLocked()) {
            Log.debug("onResumeBody: isDeviceOrientationLocked");
            nativeSetWindowInfo(UE4.isDeviceOrientationLockedPortrait(), this.DepthBufferPreference);
        } else {
            if (getResources().getConfiguration().orientation == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            nativeSetWindowInfo(z16, this.DepthBufferPreference);
        }
        if (_activity != null && UE4.isImmersiveMode() && this.ShouldHideUI) {
            restoreTransparentBars();
            View decorView = _activity.getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.epicgames.ue4.GameActivity.15
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i16) {
                    GameActivity.Log.debug("=== Restoring Transparent Bars due to Visibility Change ===");
                    GameActivity.this.restoreTransparentBars();
                }
            });
            decorView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.epicgames.ue4.GameActivity.16
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean z17) {
                    GameActivity.Log.debug("=== Restoring Transparent Bars due to Focus Change ===");
                    GameActivity.this.restoreTransparentBars();
                }
            });
        }
        Activity activity = _activity;
        if (activity != null && this.UseDisplayCutout) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            i3 = attributes.layoutInDisplayCutoutMode;
            if (i3 != 1) {
                attributes.layoutInDisplayCutoutMode = 1;
                _activity.getWindow().setAttributes(attributes);
            }
        }
        if (this.HasAllFiles) {
            Log.debug("==============> Resuming main init");
            nativeResumeMainInit();
            this.InitCompletedOK = true;
        } else if (_activity != null) {
            nativeOnInitialDownloadStarted();
            Log.debug("==============> Posting request for downloader activity");
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.epicgames.ue4.GameActivity.17
                @Override // java.lang.Runnable
                public void run() {
                    Class<Activity> cls;
                    GameActivity.Log.debug("==============> Starting activity to check files and download if required");
                    if (GameActivity.this.mDownloadShimInterface != null) {
                        cls = GameActivity.this.mDownloadShimInterface.getDownloaderType();
                    } else {
                        cls = null;
                    }
                    if (cls == null) {
                        Object downloaderType = GameActivity.this.getDownloaderType();
                        if (downloaderType instanceof Class) {
                            cls = (Class) downloaderType;
                        }
                    }
                    if (cls == null) {
                        return;
                    }
                    Intent intent = new Intent(GameActivity._activity, cls);
                    intent.addFlags(65536);
                    GameActivity._activity.startActivityForResult(intent, 80001);
                    if (GameActivity.this.noActionAnimID != -1) {
                        GameActivity._activity.overridePendingTransition(GameActivity.this.noActionAnimID, GameActivity.this.noActionAnimID);
                    }
                }
            });
        }
        LocalNotificationCheckAppOpen();
        this.bKeyboardShowing = false;
        GCloudAppLifecycle.Instance.onResume();
        try {
            Log.i("GVoiceJava", "call gvoice resume interface");
            GCloudVoiceEngine.getInstance().Resume();
        } catch (Exception unused) {
        }
        UE4.profileEnd();
        Log.debug("==============> GameActive.onResume complete!");
    }

    private void parseCommandLineParams(String str) {
        Log.debug("Parsing commandline: " + str);
        Iterator<String> it = ParseSegments(str, " ", "\"", "\"").iterator();
        while (it.hasNext()) {
            String trim = it.next().trim();
            if (trim.startsWith("-")) {
                String substring = trim.substring(1);
                ArrayList<String> ParseSegments = ParseSegments(substring, ContainerUtils.KEY_VALUE_DELIMITER, "\"", "\"");
                if (ParseSegments.size() == 2) {
                    this.CommandLineFlags.put(ParseSegments.get(0).toLowerCase(), RemoveSurrounds(ParseSegments.get(1), "\"", "\""));
                } else {
                    this.CommandLineFlags.put(substring.toLowerCase(), "");
                }
            } else {
                this.CommandLineArguments.add(RemoveSurrounds(trim, "\"", "\""));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:234:0x09a5, code lost:
    
        r31.ForceExitMessage = getResourceStringOrDefault(r10, r2.get("error"), "This device cannot run this game.");
        r31.bForceGameEndWithError = true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0af8  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0b0f  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0b5d  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0bb8 A[LOOP:3: B:159:0x0bb2->B:161:0x0bb8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0b1f  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0aec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x07ed A[Catch: IOException -> 0x0a30, TryCatch #8 {IOException -> 0x0a30, blocks: (B:178:0x07e4, B:180:0x07ed, B:181:0x0801, B:183:0x080a, B:184:0x0820, B:186:0x0826, B:188:0x0859, B:190:0x0862, B:191:0x0878, B:193:0x087e, B:195:0x08b1, B:200:0x09bc, B:207:0x08c7, B:209:0x08d2, B:210:0x08dd, B:212:0x08e8, B:213:0x08fe, B:215:0x090c, B:216:0x091d, B:218:0x092b, B:219:0x093c, B:221:0x094a, B:222:0x095b, B:224:0x0969, B:227:0x097e, B:229:0x0984, B:231:0x098e, B:234:0x09a5, B:305:0x0774, B:311:0x0796, B:313:0x07a1, B:314:0x07b6, B:308:0x07ba, B:317:0x07c0, B:318:0x07c5, B:320:0x07cb, B:419:0x09e7, B:421:0x0a09), top: B:177:0x07e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x080a A[Catch: IOException -> 0x0a30, TryCatch #8 {IOException -> 0x0a30, blocks: (B:178:0x07e4, B:180:0x07ed, B:181:0x0801, B:183:0x080a, B:184:0x0820, B:186:0x0826, B:188:0x0859, B:190:0x0862, B:191:0x0878, B:193:0x087e, B:195:0x08b1, B:200:0x09bc, B:207:0x08c7, B:209:0x08d2, B:210:0x08dd, B:212:0x08e8, B:213:0x08fe, B:215:0x090c, B:216:0x091d, B:218:0x092b, B:219:0x093c, B:221:0x094a, B:222:0x095b, B:224:0x0969, B:227:0x097e, B:229:0x0984, B:231:0x098e, B:234:0x09a5, B:305:0x0774, B:311:0x0796, B:313:0x07a1, B:314:0x07b6, B:308:0x07ba, B:317:0x07c0, B:318:0x07c5, B:320:0x07cb, B:419:0x09e7, B:421:0x0a09), top: B:177:0x07e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0862 A[Catch: IOException -> 0x0a30, TryCatch #8 {IOException -> 0x0a30, blocks: (B:178:0x07e4, B:180:0x07ed, B:181:0x0801, B:183:0x080a, B:184:0x0820, B:186:0x0826, B:188:0x0859, B:190:0x0862, B:191:0x0878, B:193:0x087e, B:195:0x08b1, B:200:0x09bc, B:207:0x08c7, B:209:0x08d2, B:210:0x08dd, B:212:0x08e8, B:213:0x08fe, B:215:0x090c, B:216:0x091d, B:218:0x092b, B:219:0x093c, B:221:0x094a, B:222:0x095b, B:224:0x0969, B:227:0x097e, B:229:0x0984, B:231:0x098e, B:234:0x09a5, B:305:0x0774, B:311:0x0796, B:313:0x07a1, B:314:0x07b6, B:308:0x07ba, B:317:0x07c0, B:318:0x07c5, B:320:0x07cb, B:419:0x09e7, B:421:0x0a09), top: B:177:0x07e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x08c0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x09c7  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x09c5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x08d2 A[Catch: IOException -> 0x0a30, TryCatch #8 {IOException -> 0x0a30, blocks: (B:178:0x07e4, B:180:0x07ed, B:181:0x0801, B:183:0x080a, B:184:0x0820, B:186:0x0826, B:188:0x0859, B:190:0x0862, B:191:0x0878, B:193:0x087e, B:195:0x08b1, B:200:0x09bc, B:207:0x08c7, B:209:0x08d2, B:210:0x08dd, B:212:0x08e8, B:213:0x08fe, B:215:0x090c, B:216:0x091d, B:218:0x092b, B:219:0x093c, B:221:0x094a, B:222:0x095b, B:224:0x0969, B:227:0x097e, B:229:0x0984, B:231:0x098e, B:234:0x09a5, B:305:0x0774, B:311:0x0796, B:313:0x07a1, B:314:0x07b6, B:308:0x07ba, B:317:0x07c0, B:318:0x07c5, B:320:0x07cb, B:419:0x09e7, B:421:0x0a09), top: B:177:0x07e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x08e8 A[Catch: IOException -> 0x0a30, TryCatch #8 {IOException -> 0x0a30, blocks: (B:178:0x07e4, B:180:0x07ed, B:181:0x0801, B:183:0x080a, B:184:0x0820, B:186:0x0826, B:188:0x0859, B:190:0x0862, B:191:0x0878, B:193:0x087e, B:195:0x08b1, B:200:0x09bc, B:207:0x08c7, B:209:0x08d2, B:210:0x08dd, B:212:0x08e8, B:213:0x08fe, B:215:0x090c, B:216:0x091d, B:218:0x092b, B:219:0x093c, B:221:0x094a, B:222:0x095b, B:224:0x0969, B:227:0x097e, B:229:0x0984, B:231:0x098e, B:234:0x09a5, B:305:0x0774, B:311:0x0796, B:313:0x07a1, B:314:0x07b6, B:308:0x07ba, B:317:0x07c0, B:318:0x07c5, B:320:0x07cb, B:419:0x09e7, B:421:0x0a09), top: B:177:0x07e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x090c A[Catch: IOException -> 0x0a30, TryCatch #8 {IOException -> 0x0a30, blocks: (B:178:0x07e4, B:180:0x07ed, B:181:0x0801, B:183:0x080a, B:184:0x0820, B:186:0x0826, B:188:0x0859, B:190:0x0862, B:191:0x0878, B:193:0x087e, B:195:0x08b1, B:200:0x09bc, B:207:0x08c7, B:209:0x08d2, B:210:0x08dd, B:212:0x08e8, B:213:0x08fe, B:215:0x090c, B:216:0x091d, B:218:0x092b, B:219:0x093c, B:221:0x094a, B:222:0x095b, B:224:0x0969, B:227:0x097e, B:229:0x0984, B:231:0x098e, B:234:0x09a5, B:305:0x0774, B:311:0x0796, B:313:0x07a1, B:314:0x07b6, B:308:0x07ba, B:317:0x07c0, B:318:0x07c5, B:320:0x07cb, B:419:0x09e7, B:421:0x0a09), top: B:177:0x07e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:218:0x092b A[Catch: IOException -> 0x0a30, TryCatch #8 {IOException -> 0x0a30, blocks: (B:178:0x07e4, B:180:0x07ed, B:181:0x0801, B:183:0x080a, B:184:0x0820, B:186:0x0826, B:188:0x0859, B:190:0x0862, B:191:0x0878, B:193:0x087e, B:195:0x08b1, B:200:0x09bc, B:207:0x08c7, B:209:0x08d2, B:210:0x08dd, B:212:0x08e8, B:213:0x08fe, B:215:0x090c, B:216:0x091d, B:218:0x092b, B:219:0x093c, B:221:0x094a, B:222:0x095b, B:224:0x0969, B:227:0x097e, B:229:0x0984, B:231:0x098e, B:234:0x09a5, B:305:0x0774, B:311:0x0796, B:313:0x07a1, B:314:0x07b6, B:308:0x07ba, B:317:0x07c0, B:318:0x07c5, B:320:0x07cb, B:419:0x09e7, B:421:0x0a09), top: B:177:0x07e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x094a A[Catch: IOException -> 0x0a30, TryCatch #8 {IOException -> 0x0a30, blocks: (B:178:0x07e4, B:180:0x07ed, B:181:0x0801, B:183:0x080a, B:184:0x0820, B:186:0x0826, B:188:0x0859, B:190:0x0862, B:191:0x0878, B:193:0x087e, B:195:0x08b1, B:200:0x09bc, B:207:0x08c7, B:209:0x08d2, B:210:0x08dd, B:212:0x08e8, B:213:0x08fe, B:215:0x090c, B:216:0x091d, B:218:0x092b, B:219:0x093c, B:221:0x094a, B:222:0x095b, B:224:0x0969, B:227:0x097e, B:229:0x0984, B:231:0x098e, B:234:0x09a5, B:305:0x0774, B:311:0x0796, B:313:0x07a1, B:314:0x07b6, B:308:0x07ba, B:317:0x07c0, B:318:0x07c5, B:320:0x07cb, B:419:0x09e7, B:421:0x0a09), top: B:177:0x07e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0969 A[Catch: IOException -> 0x0a30, TryCatch #8 {IOException -> 0x0a30, blocks: (B:178:0x07e4, B:180:0x07ed, B:181:0x0801, B:183:0x080a, B:184:0x0820, B:186:0x0826, B:188:0x0859, B:190:0x0862, B:191:0x0878, B:193:0x087e, B:195:0x08b1, B:200:0x09bc, B:207:0x08c7, B:209:0x08d2, B:210:0x08dd, B:212:0x08e8, B:213:0x08fe, B:215:0x090c, B:216:0x091d, B:218:0x092b, B:219:0x093c, B:221:0x094a, B:222:0x095b, B:224:0x0969, B:227:0x097e, B:229:0x0984, B:231:0x098e, B:234:0x09a5, B:305:0x0774, B:311:0x0796, B:313:0x07a1, B:314:0x07b6, B:308:0x07ba, B:317:0x07c0, B:318:0x07c5, B:320:0x07cb, B:419:0x09e7, B:421:0x0a09), top: B:177:0x07e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x097c  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x098e A[Catch: IOException -> 0x0a30, TryCatch #8 {IOException -> 0x0a30, blocks: (B:178:0x07e4, B:180:0x07ed, B:181:0x0801, B:183:0x080a, B:184:0x0820, B:186:0x0826, B:188:0x0859, B:190:0x0862, B:191:0x0878, B:193:0x087e, B:195:0x08b1, B:200:0x09bc, B:207:0x08c7, B:209:0x08d2, B:210:0x08dd, B:212:0x08e8, B:213:0x08fe, B:215:0x090c, B:216:0x091d, B:218:0x092b, B:219:0x093c, B:221:0x094a, B:222:0x095b, B:224:0x0969, B:227:0x097e, B:229:0x0984, B:231:0x098e, B:234:0x09a5, B:305:0x0774, B:311:0x0796, B:313:0x07a1, B:314:0x07b6, B:308:0x07ba, B:317:0x07c0, B:318:0x07c5, B:320:0x07cb, B:419:0x09e7, B:421:0x0a09), top: B:177:0x07e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x09a5 A[EDGE_INSN: B:233:0x09a5->B:234:0x09a5 BREAK  A[LOOP:1: B:73:0x032a->B:105:0x032a], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x08fc  */
    /* JADX WARN: Removed duplicated region for block: B:438:0x0ab3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x031e  */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v18, types: [int] */
    /* JADX WARN: Type inference failed for: r13v42 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean processSystemInfo(String str, String str2) {
        WindowManager windowManager;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        String str3;
        String str4;
        String str5;
        InputStream inputStream;
        String str6;
        boolean z16;
        String str7;
        String str8;
        boolean equals;
        BufferedReader bufferedReader3;
        String str9;
        Map<String, String> map;
        boolean z17;
        int i3;
        Stack stack;
        String str10;
        Object obj;
        String str11;
        String str12;
        String trim;
        String trim2;
        String str13;
        String str14;
        String str15;
        String str16;
        int i16;
        String str17;
        int i17;
        String str18;
        boolean containsKey;
        boolean containsKey2;
        String str19;
        getGraphicsInformation();
        Map<String, String> cpuInfo = getCpuInfo();
        String str20 = "processorCount";
        int parseInt = cpuInfo.containsKey("processorCount") ? Integer.parseInt(cpuInfo.get("processorCount")) : 1;
        boolean exists = new File("/system/lib/libhoudini.so").exists();
        String str21 = "";
        String str22 = cpuInfo.containsKey("Processor") ? cpuInfo.get("Processor") : "";
        boolean contains = str22.contains("aarch64");
        boolean z18 = getProp("ro.product.cpu.abilist").contains("arm64-v8a") ? true : contains;
        for (int i18 = 0; i18 < parseInt; i18++) {
            String str23 = i18 + ":Features";
            if (cpuInfo.containsKey(str23)) {
                String str24 = cpuInfo.get(str23);
                if (str24.contains("neon")) {
                    contains = true;
                }
                if (str24.contains("asimd")) {
                    contains = true;
                    z18 = true;
                }
            }
        }
        String prop = getProp("ro.hardware");
        String str25 = cpuInfo.containsKey("Hardware") ? cpuInfo.get("Hardware") : prop;
        Log.debug("Hardware: " + str25);
        Log.debug("ro.hardware: " + prop);
        HashMap hashMap = new HashMap();
        ActivityManager activityManager = (ActivityManager) getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        String str26 = "chipset";
        int i19 = (int) ((memoryInfo.totalMem / 1024) / 1024);
        Logger logger = Log;
        StringBuilder sb5 = new StringBuilder();
        Object obj2 = "warning";
        sb5.append("Memory: ");
        sb5.append(i19);
        sb5.append(" MB");
        logger.debug(sb5.toString());
        hashMap.put("memory", Integer.toString(i19));
        String str27 = "unsupportedDevice";
        String str28 = "false";
        hashMap.put("unsupportedDevice", "false");
        String str29 = "true";
        hashMap.put("OverrideProfile", "true");
        hashMap.put("hardware", str25);
        hashMap.put("ro.hardware", prop);
        hashMap.put("processor", str22);
        hashMap.put("processorCount", Integer.toString(parseInt));
        hashMap.put("useAffinity", "false");
        hashMap.put("hasNEON", contains ? "true" : "false");
        hashMap.put("isARM64", z18 ? "true" : "false");
        String str30 = "littleCoreMask";
        hashMap.put("littleCoreMask", "0x0");
        hashMap.put("bigCoreMask", "0xffff");
        hashMap.put("SRC_GpuFamily", this.OpenGLDevice);
        hashMap.put("SRC_GlVersion", this.OpenGLDriver);
        hashMap.put("SRC_AndroidVersion", Build.VERSION.RELEASE);
        hashMap.put("SRC_DeviceMake", Build.MANUFACTURER);
        hashMap.put("SRC_DeviceModel", DeviceInfoMonitor.getModel());
        hashMap.put("SRC_DeviceBuildNumber", Build.DISPLAY);
        hashMap.put("SRC_VulkanVersion", this.VulkanVersionString);
        hashMap.put("SRC_VulkanAvailable", (!this.bSupportsVulkan || this.VulkanVersionString == AEResManagerConfigBean.DEFAULT_VERSION) ? "false" : "true");
        hashMap.put("SRC_UsingHoudini", exists ? "true" : "false");
        hashMap.put("SRC_GpuVendor", this.OpenGLVendor);
        hashMap.put("SRC_SDKLevel", Integer.toString(Build.VERSION.SDK_INT));
        hashMap.put("supportsFloatingPointRenderTargets", this.bSupportsFloatingPointRenderTargets ? "true" : "false");
        hashMap.put("TextureFormats", this.TextureFormats);
        Resources resources = getApplicationContext().getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? resources.getDimensionPixelSize(identifier) + 0 : 0;
        int identifier2 = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        int dimensionPixelSize2 = identifier2 > 0 ? resources.getDimensionPixelSize(identifier2) + 0 : 0;
        hashMap.put("statusBarHeight", Integer.toString(dimensionPixelSize));
        hashMap.put("navigationBarHeight", Integer.toString(dimensionPixelSize2));
        Activity activity = _activity;
        if (activity != null) {
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            Point point = new Point();
            if (this.ShouldHideUI) {
                defaultDisplay.getRealSize(point);
            } else {
                defaultDisplay.getSize(point);
            }
            hashMap.put("screenWidth", Integer.toString(point.x));
            hashMap.put("screenHeight", Integer.toString(point.y));
        } else {
            Context context = _context;
            if (context != null && (windowManager = (WindowManager) context.getSystemService("window")) != null) {
                Display defaultDisplay2 = windowManager.getDefaultDisplay();
                Point point2 = new Point();
                if (this.ShouldHideUI) {
                    defaultDisplay2.getRealSize(point2);
                } else {
                    defaultDisplay2.getSize(point2);
                }
                hashMap.put("screenWidth", Integer.toString(point2.x));
                hashMap.put("screenHeight", Integer.toString(point2.y));
            }
        }
        if (!this.CommandLineFlags.containsKey("noearlyrestart")) {
            hashMap.put("earlyrestart", "true");
        }
        boolean z19 = !nativeIsShippingBuild() && this.CommandLineFlags.containsKey("noconfigrulesdialog");
        InputStream configRulesStream = getConfigRulesStream(str);
        if (configRulesStream != null) {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(configRulesStream));
            } catch (Exception e16) {
                this.ConfigRulesStatus += "failed to create config rules reader. " + e16;
            }
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 == null) {
                String lowerCase = str25.toLowerCase();
                try {
                    Stack stack2 = new Stack();
                    int i26 = 0;
                    int i27 = 0;
                    while (true) {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            str3 = str27;
                            str4 = str28;
                            str5 = str30;
                            inputStream = configRulesStream;
                            bufferedReader3 = bufferedReader2;
                            str6 = str29;
                            z16 = false;
                            break;
                        }
                        str6 = str29;
                        try {
                            String trim3 = readLine.trim();
                            str4 = str28;
                            try {
                                str3 = str27;
                                if (trim3.length() >= 1) {
                                    try {
                                        if (!trim3.startsWith("//") && !trim3.startsWith(";")) {
                                            int indexOf = trim3.indexOf(":");
                                            if (indexOf != -1) {
                                                try {
                                                    trim = trim3.substring(0, indexOf).trim();
                                                    trim2 = trim3.substring(indexOf + 1).trim();
                                                    inputStream = configRulesStream;
                                                    bufferedReader3 = bufferedReader2;
                                                    z17 = z19;
                                                    map = cpuInfo;
                                                } catch (IOException e17) {
                                                    e = e17;
                                                    z16 = false;
                                                    str5 = str30;
                                                    inputStream = configRulesStream;
                                                    bufferedReader3 = bufferedReader2;
                                                }
                                                try {
                                                    if (i26 != 0) {
                                                        str13 = str30;
                                                        if (i26 != 1) {
                                                            if (i26 != 2) {
                                                                if (i26 != 3) {
                                                                    if (i26 != 4) {
                                                                        try {
                                                                            Log.debug("ConfigRules: unknown state!");
                                                                        } catch (IOException e18) {
                                                                            e = e18;
                                                                            str5 = str13;
                                                                            z16 = false;
                                                                            Log.debug("failed to read configuration rules: " + e);
                                                                            this.ConfigRulesStatus += "failed to read configuration rules : " + e + " ";
                                                                            this.ConfigRulesStatus += "configuration rules finished. " + this.ForceExitMessage;
                                                                            bufferedReader3.close();
                                                                            if (inputStream != null) {
                                                                            }
                                                                            if (hashMap.containsKey("Profile")) {
                                                                            }
                                                                            str7 = str3;
                                                                            if (hashMap.containsKey(str7)) {
                                                                            }
                                                                            String str31 = str6;
                                                                            equals = hashMap.get("useAffinity").equals(str31);
                                                                            int intValue = Integer.decode(hashMap.get(str5)).intValue();
                                                                            int intValue2 = Integer.decode(hashMap.get("bigCoreMask")).intValue();
                                                                            Logger logger2 = Log;
                                                                            StringBuilder sb6 = new StringBuilder();
                                                                            sb6.append("UseAffinity: ");
                                                                            if (!equals) {
                                                                            }
                                                                            sb6.append(str31);
                                                                            logger2.debug(sb6.toString());
                                                                            Log.debug("BigCoreMask: 0x" + Integer.toHexString(intValue2));
                                                                            Log.debug("LittleCoreMask: 0x" + Integer.toHexString(intValue));
                                                                            nativeSetAffinityInfo(equals, intValue2, intValue);
                                                                            String[] strArr = new String[hashMap.size() * 2];
                                                                            ?? r132 = z16;
                                                                            while (r2.hasNext()) {
                                                                            }
                                                                            nativeSetConfigRulesVariables(strArr);
                                                                            return !this.bForceGameEndWithError;
                                                                        }
                                                                    } else if (trim.equals("if")) {
                                                                        i27++;
                                                                        str28 = str4;
                                                                        str29 = str6;
                                                                        str27 = str3;
                                                                        configRulesStream = inputStream;
                                                                        bufferedReader2 = bufferedReader3;
                                                                        z19 = z17;
                                                                        cpuInfo = map;
                                                                        str30 = str13;
                                                                    } else if (i27 > 0) {
                                                                        if (trim.equals("endif")) {
                                                                            i27--;
                                                                            str28 = str4;
                                                                            str29 = str6;
                                                                            str27 = str3;
                                                                            configRulesStream = inputStream;
                                                                            bufferedReader2 = bufferedReader3;
                                                                            z19 = z17;
                                                                            cpuInfo = map;
                                                                            str30 = str13;
                                                                        }
                                                                    } else if (trim.equals("endif")) {
                                                                        i26 = ((Integer) stack2.pop()).intValue();
                                                                        str28 = str4;
                                                                        str29 = str6;
                                                                        str27 = str3;
                                                                        configRulesStream = inputStream;
                                                                        bufferedReader2 = bufferedReader3;
                                                                        z19 = z17;
                                                                        cpuInfo = map;
                                                                        str30 = str13;
                                                                    }
                                                                    str12 = str21;
                                                                    i3 = i26;
                                                                    stack = stack2;
                                                                    str10 = str26;
                                                                    obj = obj2;
                                                                    str11 = str20;
                                                                    str5 = str13;
                                                                    str9 = lowerCase;
                                                                    obj2 = obj;
                                                                    str21 = str12;
                                                                    str28 = str4;
                                                                    str29 = str6;
                                                                    str27 = str3;
                                                                    configRulesStream = inputStream;
                                                                    bufferedReader2 = bufferedReader3;
                                                                    z19 = z17;
                                                                    cpuInfo = map;
                                                                    lowerCase = str9;
                                                                    i26 = i3;
                                                                } else if (trim.equals("endif")) {
                                                                    i26 = ((Integer) stack2.pop()).intValue();
                                                                    str28 = str4;
                                                                    str29 = str6;
                                                                    str27 = str3;
                                                                    configRulesStream = inputStream;
                                                                    bufferedReader2 = bufferedReader3;
                                                                    z19 = z17;
                                                                    cpuInfo = map;
                                                                    str30 = str13;
                                                                } else if (trim.equals("else") || trim.equals("elseif")) {
                                                                    Log.debug("ConfigRules: unexpected " + trim + " while handling false condition!");
                                                                    str12 = str21;
                                                                    i3 = i26;
                                                                    stack = stack2;
                                                                    str10 = str26;
                                                                    obj = obj2;
                                                                    str11 = str20;
                                                                    str5 = str13;
                                                                    str9 = lowerCase;
                                                                    obj2 = obj;
                                                                    str21 = str12;
                                                                    str28 = str4;
                                                                    str29 = str6;
                                                                    str27 = str3;
                                                                    configRulesStream = inputStream;
                                                                    bufferedReader2 = bufferedReader3;
                                                                    z19 = z17;
                                                                    cpuInfo = map;
                                                                    lowerCase = str9;
                                                                    i26 = i3;
                                                                }
                                                                stack2 = stack;
                                                                str30 = str5;
                                                                str20 = str11;
                                                                str26 = str10;
                                                            } else if (trim.equals("if")) {
                                                                i27++;
                                                                str28 = str4;
                                                                str29 = str6;
                                                                str27 = str3;
                                                                configRulesStream = inputStream;
                                                                bufferedReader2 = bufferedReader3;
                                                                z19 = z17;
                                                                cpuInfo = map;
                                                                str30 = str13;
                                                            } else {
                                                                if (i27 > 0) {
                                                                    if (trim.equals("endif")) {
                                                                        i27--;
                                                                        str28 = str4;
                                                                        str29 = str6;
                                                                        str27 = str3;
                                                                        configRulesStream = inputStream;
                                                                        bufferedReader2 = bufferedReader3;
                                                                        z19 = z17;
                                                                        cpuInfo = map;
                                                                        str30 = str13;
                                                                    }
                                                                } else {
                                                                    if (trim.equals("endif")) {
                                                                        i26 = ((Integer) stack2.pop()).intValue();
                                                                    } else if (trim.equals("else")) {
                                                                        str28 = str4;
                                                                        str29 = str6;
                                                                        str27 = str3;
                                                                        configRulesStream = inputStream;
                                                                        bufferedReader2 = bufferedReader3;
                                                                        z19 = z17;
                                                                        cpuInfo = map;
                                                                        str30 = str13;
                                                                        i26 = 3;
                                                                    } else if (trim.equals("elseif")) {
                                                                        ArrayList<String> ParseSegments = ParseSegments(trim2, ",", "(\"", ")\"");
                                                                        if (ParseSegments.size() > 0) {
                                                                            i26 = EvaluateConditions(hashMap, ParseSegments, str21) ? 1 : 2;
                                                                        } else {
                                                                            i26 = 4;
                                                                        }
                                                                    }
                                                                    str28 = str4;
                                                                    str29 = str6;
                                                                    str27 = str3;
                                                                    configRulesStream = inputStream;
                                                                    bufferedReader2 = bufferedReader3;
                                                                    z19 = z17;
                                                                    cpuInfo = map;
                                                                    str30 = str13;
                                                                }
                                                                str12 = str21;
                                                                i3 = i26;
                                                                stack = stack2;
                                                                str10 = str26;
                                                                obj = obj2;
                                                                str11 = str20;
                                                                str5 = str13;
                                                                str9 = lowerCase;
                                                                obj2 = obj;
                                                                str21 = str12;
                                                                str28 = str4;
                                                                str29 = str6;
                                                                str27 = str3;
                                                                configRulesStream = inputStream;
                                                                bufferedReader2 = bufferedReader3;
                                                                z19 = z17;
                                                                cpuInfo = map;
                                                                lowerCase = str9;
                                                                i26 = i3;
                                                                stack2 = stack;
                                                                str30 = str5;
                                                                str20 = str11;
                                                                str26 = str10;
                                                            }
                                                        } else if (trim.equals("else")) {
                                                            str28 = str4;
                                                            str29 = str6;
                                                            str27 = str3;
                                                            configRulesStream = inputStream;
                                                            bufferedReader2 = bufferedReader3;
                                                            z19 = z17;
                                                            cpuInfo = map;
                                                            str30 = str13;
                                                            i26 = 4;
                                                        } else if (trim.equals("endif")) {
                                                            i26 = ((Integer) stack2.pop()).intValue();
                                                            str28 = str4;
                                                            str29 = str6;
                                                            str27 = str3;
                                                            configRulesStream = inputStream;
                                                            bufferedReader2 = bufferedReader3;
                                                            z19 = z17;
                                                            cpuInfo = map;
                                                            str30 = str13;
                                                        }
                                                    } else {
                                                        str13 = str30;
                                                        if (trim.equals("else") || trim.equals("elseif") || trim.equals("endif")) {
                                                            Log.debug("ConfigRules: unexpected " + trim + " encountered!");
                                                        }
                                                    }
                                                    if (trim.equals("set")) {
                                                        Iterator<String> it = ParseSegments(RemoveSurrounds(trim2, "(", ")"), ",", "(\"", ")\"").iterator();
                                                        while (it.hasNext()) {
                                                            ArrayList<String> ParseSegments2 = ParseSegments(it.next(), ContainerUtils.KEY_VALUE_DELIMITER, "\"", "\"");
                                                            if (ParseSegments2.size() == 2) {
                                                                z16 = false;
                                                                try {
                                                                    String RemoveSurrounds = RemoveSurrounds(ParseSegments2.get(0), "\"", "\"");
                                                                    String ExpandVariables = ExpandVariables(hashMap, RemoveSurrounds(ParseSegments2.get(1), "\"", "\""));
                                                                    if (RemoveSurrounds.startsWith("APPEND_")) {
                                                                        String substring = RemoveSurrounds.substring(7);
                                                                        if (hashMap.containsKey(substring)) {
                                                                            ExpandVariables = hashMap.get(substring) + ExpandVariables;
                                                                        }
                                                                        hashMap.put(substring, ExpandVariables);
                                                                    } else {
                                                                        hashMap.put(RemoveSurrounds, ExpandVariables);
                                                                    }
                                                                } catch (IOException e19) {
                                                                    e = e19;
                                                                    str5 = str13;
                                                                    Log.debug("failed to read configuration rules: " + e);
                                                                    this.ConfigRulesStatus += "failed to read configuration rules : " + e + " ";
                                                                    this.ConfigRulesStatus += "configuration rules finished. " + this.ForceExitMessage;
                                                                    bufferedReader3.close();
                                                                    if (inputStream != null) {
                                                                    }
                                                                    if (hashMap.containsKey("Profile")) {
                                                                    }
                                                                    str7 = str3;
                                                                    if (hashMap.containsKey(str7)) {
                                                                    }
                                                                    String str312 = str6;
                                                                    equals = hashMap.get("useAffinity").equals(str312);
                                                                    int intValue3 = Integer.decode(hashMap.get(str5)).intValue();
                                                                    int intValue22 = Integer.decode(hashMap.get("bigCoreMask")).intValue();
                                                                    Logger logger22 = Log;
                                                                    StringBuilder sb62 = new StringBuilder();
                                                                    sb62.append("UseAffinity: ");
                                                                    if (!equals) {
                                                                    }
                                                                    sb62.append(str312);
                                                                    logger22.debug(sb62.toString());
                                                                    Log.debug("BigCoreMask: 0x" + Integer.toHexString(intValue22));
                                                                    Log.debug("LittleCoreMask: 0x" + Integer.toHexString(intValue3));
                                                                    nativeSetAffinityInfo(equals, intValue22, intValue3);
                                                                    String[] strArr2 = new String[hashMap.size() * 2];
                                                                    ?? r1322 = z16;
                                                                    while (r2.hasNext()) {
                                                                    }
                                                                    nativeSetConfigRulesVariables(strArr2);
                                                                    return !this.bForceGameEndWithError;
                                                                }
                                                            }
                                                        }
                                                    } else if (trim.equals(QCircleLpReportDc05507.KEY_CLEAR)) {
                                                        Iterator<String> it5 = ParseSegments(RemoveSurrounds(trim2, "(", ")"), ",", "(\"", ")\"").iterator();
                                                        while (it5.hasNext()) {
                                                            hashMap.remove(RemoveSurrounds(it5.next(), "\"", "\""));
                                                        }
                                                    } else {
                                                        String str32 = str26;
                                                        if (trim.equals(str32)) {
                                                            if (hashMap.containsKey(str32)) {
                                                                str11 = str20;
                                                                str10 = str32;
                                                                stack = stack2;
                                                                str5 = str13;
                                                                str16 = str14;
                                                                z16 = false;
                                                                str15 = lowerCase;
                                                            } else {
                                                                ArrayList<String> ParseSegments3 = ParseSegments(trim2, ",", "\"", "\"");
                                                                if (ParseSegments3.size() == 7 && lowerCase.contains(RemoveSurrounds(ParseSegments3.get(0), "\"", "\"").toLowerCase())) {
                                                                    hashMap.put("useAffinity", RemoveSurrounds(ParseSegments3.get(1), "\"", "\""));
                                                                    hashMap.put(str32, RemoveSurrounds(ParseSegments3.get(2), "\"", "\""));
                                                                    hashMap.put(ChildProcessServiceWrapper.PROCESS_TYPE_GPU, RemoveSurrounds(ParseSegments3.get(3), "\"", "\""));
                                                                    hashMap.put(str20, RemoveSurrounds(ParseSegments3.get(4), "\"", "\""));
                                                                    hashMap.put("bigCoreMask", RemoveSurrounds(ParseSegments3.get(5), "\"", "\""));
                                                                    str18 = str13;
                                                                    try {
                                                                        hashMap.put(str18, RemoveSurrounds(ParseSegments3.get(6), "\"", "\""));
                                                                        Log.debug("Chipset: " + hashMap.get(str32));
                                                                        Log.debug("GPU: " + hashMap.get(ChildProcessServiceWrapper.PROCESS_TYPE_GPU));
                                                                    } catch (IOException e26) {
                                                                        e = e26;
                                                                        str5 = str18;
                                                                        z16 = false;
                                                                        Log.debug("failed to read configuration rules: " + e);
                                                                        this.ConfigRulesStatus += "failed to read configuration rules : " + e + " ";
                                                                        this.ConfigRulesStatus += "configuration rules finished. " + this.ForceExitMessage;
                                                                        bufferedReader3.close();
                                                                        if (inputStream != null) {
                                                                        }
                                                                        if (hashMap.containsKey("Profile")) {
                                                                        }
                                                                        str7 = str3;
                                                                        if (hashMap.containsKey(str7)) {
                                                                        }
                                                                        String str3122 = str6;
                                                                        equals = hashMap.get("useAffinity").equals(str3122);
                                                                        int intValue32 = Integer.decode(hashMap.get(str5)).intValue();
                                                                        int intValue222 = Integer.decode(hashMap.get("bigCoreMask")).intValue();
                                                                        Logger logger222 = Log;
                                                                        StringBuilder sb622 = new StringBuilder();
                                                                        sb622.append("UseAffinity: ");
                                                                        if (!equals) {
                                                                        }
                                                                        sb622.append(str3122);
                                                                        logger222.debug(sb622.toString());
                                                                        Log.debug("BigCoreMask: 0x" + Integer.toHexString(intValue222));
                                                                        Log.debug("LittleCoreMask: 0x" + Integer.toHexString(intValue32));
                                                                        nativeSetAffinityInfo(equals, intValue222, intValue32);
                                                                        String[] strArr22 = new String[hashMap.size() * 2];
                                                                        ?? r13222 = z16;
                                                                        while (r2.hasNext()) {
                                                                        }
                                                                        nativeSetConfigRulesVariables(strArr22);
                                                                        return !this.bForceGameEndWithError;
                                                                    }
                                                                } else {
                                                                    str18 = str13;
                                                                }
                                                                str15 = lowerCase;
                                                                str11 = str20;
                                                                str10 = str32;
                                                                stack = stack2;
                                                                str16 = str14;
                                                                z16 = false;
                                                                str5 = str18;
                                                            }
                                                            i16 = i26;
                                                        } else {
                                                            str11 = str20;
                                                            str5 = str13;
                                                            str15 = lowerCase;
                                                            try {
                                                                if (trim.equals("if")) {
                                                                    stack2.push(Integer.valueOf(i26));
                                                                    ArrayList<String> ParseSegments4 = ParseSegments(trim2, ",", "(\"", ")\"");
                                                                    if (ParseSegments4.size() > 0) {
                                                                        str17 = str14;
                                                                        i17 = EvaluateConditions(hashMap, ParseSegments4, str17) ? 1 : 2;
                                                                    } else {
                                                                        str17 = str14;
                                                                        i17 = 4;
                                                                    }
                                                                    str10 = str32;
                                                                    i26 = i17;
                                                                    stack = stack2;
                                                                    z16 = false;
                                                                    str16 = str17;
                                                                    if (hashMap.containsKey("log")) {
                                                                        Log.debug(hashMap.get("log"));
                                                                        hashMap.remove("log");
                                                                    }
                                                                    if (hashMap.containsKey("dumpcpuinfo")) {
                                                                        hashMap.remove("dumpcpuinfo");
                                                                        Log.debug("cpuInfo:");
                                                                        for (Map.Entry<String, String> entry : map.entrySet()) {
                                                                            Log.debug("  " + entry.getKey() + " = " + entry.getValue());
                                                                        }
                                                                    }
                                                                    if (hashMap.containsKey("dumpvars")) {
                                                                        hashMap.remove("dumpvars");
                                                                        Log.debug("variables:");
                                                                        for (Map.Entry<String, String> entry2 : hashMap.entrySet()) {
                                                                            Log.debug("  " + entry2.getKey() + " = " + entry2.getValue());
                                                                        }
                                                                    }
                                                                    containsKey = hashMap.containsKey("error");
                                                                    Object obj3 = obj2;
                                                                    containsKey2 = hashMap.containsKey(obj3);
                                                                    if (!containsKey && !containsKey2) {
                                                                        if (hashMap.containsKey("break")) {
                                                                            break;
                                                                        }
                                                                        obj2 = obj3;
                                                                        str21 = str16;
                                                                        str28 = str4;
                                                                        str29 = str6;
                                                                        str27 = str3;
                                                                        configRulesStream = inputStream;
                                                                        bufferedReader2 = bufferedReader3;
                                                                        z19 = z17;
                                                                        cpuInfo = map;
                                                                        lowerCase = str15;
                                                                        stack2 = stack;
                                                                        str30 = str5;
                                                                        str20 = str11;
                                                                        str26 = str10;
                                                                    }
                                                                    this.ForceExitLink = str16;
                                                                    if (hashMap.containsKey(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK)) {
                                                                        this.ForceExitLink = hashMap.get(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK);
                                                                    }
                                                                    this.ForceExitUpdateButtonText = str16;
                                                                    if (hashMap.containsKey("updatebutton")) {
                                                                        str19 = str2;
                                                                        this.ForceExitUpdateButtonText = getResourceStringOrDefault(str19, hashMap.get("updatebutton"), this.ForceExitUpdateButtonText);
                                                                    } else {
                                                                        str19 = str2;
                                                                    }
                                                                    this.ForceExitHelpButtonText = "Help";
                                                                    if (hashMap.containsKey("helpbutton")) {
                                                                        this.ForceExitHelpButtonText = getResourceStringOrDefault(str19, hashMap.get("helpbutton"), this.ForceExitHelpButtonText);
                                                                    }
                                                                    this.ForceExitQuitButtonText = "Quit";
                                                                    if (hashMap.containsKey("exitbutton")) {
                                                                        this.ForceExitQuitButtonText = getResourceStringOrDefault(str19, hashMap.get("exitbutton"), this.ForceExitQuitButtonText);
                                                                    }
                                                                    this.ForceExitContinueButtonText = "Continue";
                                                                    if (hashMap.containsKey("continuebutton")) {
                                                                        this.ForceExitContinueButtonText = getResourceStringOrDefault(str19, hashMap.get("continuebutton"), this.ForceExitContinueButtonText);
                                                                    }
                                                                    this.ForceExitCaption = "Device not supported";
                                                                    if (hashMap.containsKey("caption")) {
                                                                        this.ForceExitCaption = getResourceStringOrDefault(str19, hashMap.get("caption"), this.ForceExitCaption);
                                                                    }
                                                                    if (z17) {
                                                                        if (containsKey2) {
                                                                            hashMap.remove(obj3);
                                                                            containsKey2 = z16;
                                                                        }
                                                                        if (containsKey) {
                                                                            hashMap.remove("error");
                                                                            containsKey = z16;
                                                                        }
                                                                    }
                                                                    if (containsKey2) {
                                                                        this.ForceExitMessage = getResourceStringOrDefault(str19, hashMap.get(obj3), "This device may not run this game.");
                                                                        hashMap.remove(obj3);
                                                                        this.bForceGameEndWithWarning = true;
                                                                    }
                                                                    if (containsKey) {
                                                                        break;
                                                                    }
                                                                    if (hashMap.containsKey("break")) {
                                                                    }
                                                                } else {
                                                                    str10 = str32;
                                                                    str16 = str14;
                                                                    if (trim.equals("condition")) {
                                                                        ArrayList<String> ParseSegments5 = ParseSegments(trim2, ",", "(\"", ")\"");
                                                                        int size = ParseSegments5.size();
                                                                        if (size == 2 || size == 3) {
                                                                            try {
                                                                                ArrayList<String> ParseSegments6 = ParseSegments(RemoveSurrounds(ParseSegments5.get(0), "(", ")"), ",", "(\"", ")\"");
                                                                                i16 = i26;
                                                                                ArrayList<String> ParseSegments7 = ParseSegments(RemoveSurrounds(ParseSegments5.get(1), "(", ")"), ",", "(\"", ")\"");
                                                                                stack = stack2;
                                                                                ArrayList<String> ParseSegments8 = size == 3 ? ParseSegments(RemoveSurrounds(ParseSegments5.get(2), "(", ")"), ",", "(\"", ")\"") : new ArrayList<>();
                                                                                if (EvaluateConditions(hashMap, ParseSegments6, str16)) {
                                                                                    Iterator<String> it6 = ParseSegments7.iterator();
                                                                                    while (it6.hasNext()) {
                                                                                        ArrayList<String> ParseSegments9 = ParseSegments(it6.next(), ContainerUtils.KEY_VALUE_DELIMITER, "\"", "\"");
                                                                                        if (ParseSegments9.size() == 2) {
                                                                                            String RemoveSurrounds2 = RemoveSurrounds(ParseSegments9.get(0), "\"", "\"");
                                                                                            String ExpandVariables2 = ExpandVariables(hashMap, RemoveSurrounds(ParseSegments9.get(1), "\"", "\""));
                                                                                            if (RemoveSurrounds2.startsWith("APPEND_")) {
                                                                                                String substring2 = RemoveSurrounds2.substring(7);
                                                                                                if (hashMap.containsKey(substring2)) {
                                                                                                    ExpandVariables2 = hashMap.get(substring2) + ExpandVariables2;
                                                                                                }
                                                                                                hashMap.put(substring2, ExpandVariables2);
                                                                                            } else {
                                                                                                hashMap.put(RemoveSurrounds2, ExpandVariables2);
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    z16 = false;
                                                                                    Iterator<String> it7 = ParseSegments8.iterator();
                                                                                    while (it7.hasNext()) {
                                                                                        hashMap.remove(RemoveSurrounds(it7.next(), "\"", "\""));
                                                                                    }
                                                                                }
                                                                                z16 = false;
                                                                            } catch (IOException e27) {
                                                                                e = e27;
                                                                                z16 = false;
                                                                                Log.debug("failed to read configuration rules: " + e);
                                                                                this.ConfigRulesStatus += "failed to read configuration rules : " + e + " ";
                                                                                this.ConfigRulesStatus += "configuration rules finished. " + this.ForceExitMessage;
                                                                                bufferedReader3.close();
                                                                                if (inputStream != null) {
                                                                                }
                                                                                if (hashMap.containsKey("Profile")) {
                                                                                }
                                                                                str7 = str3;
                                                                                if (hashMap.containsKey(str7)) {
                                                                                }
                                                                                String str31222 = str6;
                                                                                equals = hashMap.get("useAffinity").equals(str31222);
                                                                                int intValue322 = Integer.decode(hashMap.get(str5)).intValue();
                                                                                int intValue2222 = Integer.decode(hashMap.get("bigCoreMask")).intValue();
                                                                                Logger logger2222 = Log;
                                                                                StringBuilder sb6222 = new StringBuilder();
                                                                                sb6222.append("UseAffinity: ");
                                                                                if (!equals) {
                                                                                }
                                                                                sb6222.append(str31222);
                                                                                logger2222.debug(sb6222.toString());
                                                                                Log.debug("BigCoreMask: 0x" + Integer.toHexString(intValue2222));
                                                                                Log.debug("LittleCoreMask: 0x" + Integer.toHexString(intValue322));
                                                                                nativeSetAffinityInfo(equals, intValue2222, intValue322);
                                                                                String[] strArr222 = new String[hashMap.size() * 2];
                                                                                ?? r132222 = z16;
                                                                                while (r2.hasNext()) {
                                                                                }
                                                                                nativeSetConfigRulesVariables(strArr222);
                                                                                return !this.bForceGameEndWithError;
                                                                            }
                                                                        }
                                                                    }
                                                                    i16 = i26;
                                                                    stack = stack2;
                                                                    z16 = false;
                                                                }
                                                            } catch (IOException e28) {
                                                                e = e28;
                                                                z16 = false;
                                                                Log.debug("failed to read configuration rules: " + e);
                                                                this.ConfigRulesStatus += "failed to read configuration rules : " + e + " ";
                                                                this.ConfigRulesStatus += "configuration rules finished. " + this.ForceExitMessage;
                                                                bufferedReader3.close();
                                                                if (inputStream != null) {
                                                                }
                                                                if (hashMap.containsKey("Profile")) {
                                                                }
                                                                str7 = str3;
                                                                if (hashMap.containsKey(str7)) {
                                                                }
                                                                String str312222 = str6;
                                                                equals = hashMap.get("useAffinity").equals(str312222);
                                                                int intValue3222 = Integer.decode(hashMap.get(str5)).intValue();
                                                                int intValue22222 = Integer.decode(hashMap.get("bigCoreMask")).intValue();
                                                                Logger logger22222 = Log;
                                                                StringBuilder sb62222 = new StringBuilder();
                                                                sb62222.append("UseAffinity: ");
                                                                if (!equals) {
                                                                }
                                                                sb62222.append(str312222);
                                                                logger22222.debug(sb62222.toString());
                                                                Log.debug("BigCoreMask: 0x" + Integer.toHexString(intValue22222));
                                                                Log.debug("LittleCoreMask: 0x" + Integer.toHexString(intValue3222));
                                                                nativeSetAffinityInfo(equals, intValue22222, intValue3222);
                                                                String[] strArr2222 = new String[hashMap.size() * 2];
                                                                ?? r1322222 = z16;
                                                                while (r2.hasNext()) {
                                                                }
                                                                nativeSetConfigRulesVariables(strArr2222);
                                                                return !this.bForceGameEndWithError;
                                                            }
                                                        }
                                                        i26 = i16;
                                                        if (hashMap.containsKey("log")) {
                                                        }
                                                        if (hashMap.containsKey("dumpcpuinfo")) {
                                                        }
                                                        if (hashMap.containsKey("dumpvars")) {
                                                        }
                                                        containsKey = hashMap.containsKey("error");
                                                        Object obj32 = obj2;
                                                        containsKey2 = hashMap.containsKey(obj32);
                                                        if (!containsKey) {
                                                            if (hashMap.containsKey("break")) {
                                                            }
                                                        }
                                                        this.ForceExitLink = str16;
                                                        if (hashMap.containsKey(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK)) {
                                                        }
                                                        this.ForceExitUpdateButtonText = str16;
                                                        if (hashMap.containsKey("updatebutton")) {
                                                        }
                                                        this.ForceExitHelpButtonText = "Help";
                                                        if (hashMap.containsKey("helpbutton")) {
                                                        }
                                                        this.ForceExitQuitButtonText = "Quit";
                                                        if (hashMap.containsKey("exitbutton")) {
                                                        }
                                                        this.ForceExitContinueButtonText = "Continue";
                                                        if (hashMap.containsKey("continuebutton")) {
                                                        }
                                                        this.ForceExitCaption = "Device not supported";
                                                        if (hashMap.containsKey("caption")) {
                                                        }
                                                        if (z17) {
                                                        }
                                                        if (containsKey2) {
                                                        }
                                                        if (containsKey) {
                                                        }
                                                        if (hashMap.containsKey("break")) {
                                                        }
                                                    }
                                                    if (hashMap.containsKey("log")) {
                                                    }
                                                    if (hashMap.containsKey("dumpcpuinfo")) {
                                                    }
                                                    if (hashMap.containsKey("dumpvars")) {
                                                    }
                                                    containsKey = hashMap.containsKey("error");
                                                    Object obj322 = obj2;
                                                    containsKey2 = hashMap.containsKey(obj322);
                                                    if (!containsKey) {
                                                    }
                                                    this.ForceExitLink = str16;
                                                    if (hashMap.containsKey(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK)) {
                                                    }
                                                    this.ForceExitUpdateButtonText = str16;
                                                    if (hashMap.containsKey("updatebutton")) {
                                                    }
                                                    this.ForceExitHelpButtonText = "Help";
                                                    if (hashMap.containsKey("helpbutton")) {
                                                    }
                                                    this.ForceExitQuitButtonText = "Quit";
                                                    if (hashMap.containsKey("exitbutton")) {
                                                    }
                                                    this.ForceExitContinueButtonText = "Continue";
                                                    if (hashMap.containsKey("continuebutton")) {
                                                    }
                                                    this.ForceExitCaption = "Device not supported";
                                                    if (hashMap.containsKey("caption")) {
                                                    }
                                                    if (z17) {
                                                    }
                                                    if (containsKey2) {
                                                    }
                                                    if (containsKey) {
                                                    }
                                                    if (hashMap.containsKey("break")) {
                                                    }
                                                } catch (IOException e29) {
                                                    e = e29;
                                                    Log.debug("failed to read configuration rules: " + e);
                                                    this.ConfigRulesStatus += "failed to read configuration rules : " + e + " ";
                                                    this.ConfigRulesStatus += "configuration rules finished. " + this.ForceExitMessage;
                                                    bufferedReader3.close();
                                                    if (inputStream != null) {
                                                    }
                                                    if (hashMap.containsKey("Profile")) {
                                                    }
                                                    str7 = str3;
                                                    if (hashMap.containsKey(str7)) {
                                                    }
                                                    String str3122222 = str6;
                                                    equals = hashMap.get("useAffinity").equals(str3122222);
                                                    int intValue32222 = Integer.decode(hashMap.get(str5)).intValue();
                                                    int intValue222222 = Integer.decode(hashMap.get("bigCoreMask")).intValue();
                                                    Logger logger222222 = Log;
                                                    StringBuilder sb622222 = new StringBuilder();
                                                    sb622222.append("UseAffinity: ");
                                                    if (!equals) {
                                                    }
                                                    sb622222.append(str3122222);
                                                    logger222222.debug(sb622222.toString());
                                                    Log.debug("BigCoreMask: 0x" + Integer.toHexString(intValue222222));
                                                    Log.debug("LittleCoreMask: 0x" + Integer.toHexString(intValue32222));
                                                    nativeSetAffinityInfo(equals, intValue222222, intValue32222);
                                                    String[] strArr22222 = new String[hashMap.size() * 2];
                                                    ?? r13222222 = z16;
                                                    while (r2.hasNext()) {
                                                    }
                                                    nativeSetConfigRulesVariables(strArr22222);
                                                    return !this.bForceGameEndWithError;
                                                }
                                                str14 = str21;
                                                stack = stack2;
                                                str10 = str26;
                                                str16 = str14;
                                                z16 = false;
                                                str11 = str20;
                                                i16 = i26;
                                                str5 = str13;
                                                str15 = lowerCase;
                                                i26 = i16;
                                            }
                                        }
                                        str9 = lowerCase;
                                        map = cpuInfo;
                                        z17 = z19;
                                        inputStream = configRulesStream;
                                        bufferedReader3 = bufferedReader2;
                                        i3 = i26;
                                        stack = stack2;
                                        str10 = str26;
                                        obj = obj2;
                                        str11 = str20;
                                        str5 = str30;
                                        str12 = str21;
                                        if (trim3.startsWith("// version:")) {
                                            Integer.parseInt(trim3.substring(11));
                                        }
                                        obj2 = obj;
                                        str21 = str12;
                                        str28 = str4;
                                        str29 = str6;
                                        str27 = str3;
                                        configRulesStream = inputStream;
                                        bufferedReader2 = bufferedReader3;
                                        z19 = z17;
                                        cpuInfo = map;
                                        lowerCase = str9;
                                        i26 = i3;
                                        stack2 = stack;
                                        str30 = str5;
                                        str20 = str11;
                                        str26 = str10;
                                    } catch (IOException e36) {
                                        e = e36;
                                        str5 = str30;
                                        inputStream = configRulesStream;
                                        bufferedReader3 = bufferedReader2;
                                        z16 = false;
                                        Log.debug("failed to read configuration rules: " + e);
                                        this.ConfigRulesStatus += "failed to read configuration rules : " + e + " ";
                                        this.ConfigRulesStatus += "configuration rules finished. " + this.ForceExitMessage;
                                        bufferedReader3.close();
                                        if (inputStream != null) {
                                        }
                                        if (hashMap.containsKey("Profile")) {
                                        }
                                        str7 = str3;
                                        if (hashMap.containsKey(str7)) {
                                        }
                                        String str31222222 = str6;
                                        equals = hashMap.get("useAffinity").equals(str31222222);
                                        int intValue322222 = Integer.decode(hashMap.get(str5)).intValue();
                                        int intValue2222222 = Integer.decode(hashMap.get("bigCoreMask")).intValue();
                                        Logger logger2222222 = Log;
                                        StringBuilder sb6222222 = new StringBuilder();
                                        sb6222222.append("UseAffinity: ");
                                        if (!equals) {
                                        }
                                        sb6222222.append(str31222222);
                                        logger2222222.debug(sb6222222.toString());
                                        Log.debug("BigCoreMask: 0x" + Integer.toHexString(intValue2222222));
                                        Log.debug("LittleCoreMask: 0x" + Integer.toHexString(intValue322222));
                                        nativeSetAffinityInfo(equals, intValue2222222, intValue322222);
                                        String[] strArr222222 = new String[hashMap.size() * 2];
                                        ?? r132222222 = z16;
                                        while (r2.hasNext()) {
                                        }
                                        nativeSetConfigRulesVariables(strArr222222);
                                        return !this.bForceGameEndWithError;
                                    }
                                }
                                str9 = lowerCase;
                                map = cpuInfo;
                                z17 = z19;
                                inputStream = configRulesStream;
                                bufferedReader3 = bufferedReader2;
                                i3 = i26;
                                stack = stack2;
                                str10 = str26;
                                obj = obj2;
                                str11 = str20;
                                str5 = str30;
                                str12 = str21;
                                obj2 = obj;
                                str21 = str12;
                                str28 = str4;
                                str29 = str6;
                                str27 = str3;
                                configRulesStream = inputStream;
                                bufferedReader2 = bufferedReader3;
                                z19 = z17;
                                cpuInfo = map;
                                lowerCase = str9;
                                i26 = i3;
                                stack2 = stack;
                                str30 = str5;
                                str20 = str11;
                                str26 = str10;
                            } catch (IOException e37) {
                                e = e37;
                                str3 = str27;
                            }
                        } catch (IOException e38) {
                            e = e38;
                            str3 = str27;
                            str4 = str28;
                        }
                    }
                } catch (IOException e39) {
                    e = e39;
                    str3 = str27;
                    str4 = str28;
                    str5 = str30;
                    inputStream = configRulesStream;
                    bufferedReader3 = bufferedReader2;
                    str6 = str29;
                }
                this.ConfigRulesStatus += "configuration rules finished. " + this.ForceExitMessage;
                try {
                    bufferedReader3.close();
                } catch (IOException unused) {
                }
            } else {
                str3 = "unsupportedDevice";
                str4 = "false";
                str5 = "littleCoreMask";
                inputStream = configRulesStream;
                str6 = "true";
                z16 = false;
                if (this.bConfigRulesError) {
                    this.ForceExitCaption = getResourceStringOrDefault(str2, "CR_Caption_DeviceNotSupported", "Device Not Supported");
                    this.ForceExitQuitButtonText = getResourceStringOrDefault(str2, "CR_Button_Quit", "Quit");
                    this.ForceExitMessage = getResourceStringOrDefault(str2, "CR_Info_DeviceNotSupportedYet", "This device is in supported yet.");
                    this.bForceGameEndWithError = true;
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused2) {
                }
            }
            if (hashMap.containsKey("Profile") && !hashMap.containsKey("OverrideProfile")) {
                hashMap.remove("Profile");
            }
            str7 = str3;
            if (hashMap.containsKey(str7)) {
                String str33 = hashMap.get(str7);
                str8 = str4;
                bSupportedDevice = str33.equals(str8);
            } else {
                str8 = str4;
            }
            String str312222222 = str6;
            equals = hashMap.get("useAffinity").equals(str312222222);
            int intValue3222222 = Integer.decode(hashMap.get(str5)).intValue();
            int intValue22222222 = Integer.decode(hashMap.get("bigCoreMask")).intValue();
            Logger logger22222222 = Log;
            StringBuilder sb62222222 = new StringBuilder();
            sb62222222.append("UseAffinity: ");
            if (!equals) {
                str312222222 = str8;
            }
            sb62222222.append(str312222222);
            logger22222222.debug(sb62222222.toString());
            Log.debug("BigCoreMask: 0x" + Integer.toHexString(intValue22222222));
            Log.debug("LittleCoreMask: 0x" + Integer.toHexString(intValue3222222));
            nativeSetAffinityInfo(equals, intValue22222222, intValue3222222);
            String[] strArr2222222 = new String[hashMap.size() * 2];
            ?? r1322222222 = z16;
            for (Map.Entry<String, String> entry3 : hashMap.entrySet()) {
                int i28 = r1322222222 + 1;
                strArr2222222[r1322222222] = entry3.getKey();
                strArr2222222[i28] = entry3.getValue();
                r1322222222 = i28 + 1;
            }
            nativeSetConfigRulesVariables(strArr2222222);
            return !this.bForceGameEndWithError;
        }
        bufferedReader = null;
        bufferedReader2 = bufferedReader;
        if (bufferedReader2 == null) {
        }
        if (inputStream != null) {
        }
        if (hashMap.containsKey("Profile")) {
            hashMap.remove("Profile");
        }
        str7 = str3;
        if (hashMap.containsKey(str7)) {
        }
        String str3122222222 = str6;
        equals = hashMap.get("useAffinity").equals(str3122222222);
        int intValue32222222 = Integer.decode(hashMap.get(str5)).intValue();
        int intValue222222222 = Integer.decode(hashMap.get("bigCoreMask")).intValue();
        Logger logger222222222 = Log;
        StringBuilder sb622222222 = new StringBuilder();
        sb622222222.append("UseAffinity: ");
        if (!equals) {
        }
        sb622222222.append(str3122222222);
        logger222222222.debug(sb622222222.toString());
        Log.debug("BigCoreMask: 0x" + Integer.toHexString(intValue222222222));
        Log.debug("LittleCoreMask: 0x" + Integer.toHexString(intValue32222222));
        nativeSetAffinityInfo(equals, intValue222222222, intValue32222222);
        String[] strArr22222222 = new String[hashMap.size() * 2];
        ?? r13222222222 = z16;
        while (r2.hasNext()) {
        }
        nativeSetConfigRulesVariables(strArr22222222);
        return !this.bForceGameEndWithError;
    }

    public static boolean writeFile(String str, String str2) {
        try {
            FileWriter fileWriter = new FileWriter(new File(str));
            fileWriter.write(str2);
            fileWriter.close();
            return true;
        } catch (IOException e16) {
            Log.debug("Exception: " + e16);
            return false;
        }
    }

    public void AndroidThunkJava_CMShowDressCostumeResult(int i3, int i16) {
        GameActivityThunk.GetSingleton().CMShowDressCostumeResult(i3, i16);
    }

    public void AndroidThunkJava_CMShowEndRecord(int i3, int i16) {
        GameActivityThunk.GetSingleton().CMShowEndRecord(i3, i16);
    }

    public void AndroidThunkJava_CMShowEngineFirstFrame() {
        GameActivityThunk.GetSingleton().CMShowEngineFirstFrame();
    }

    public void AndroidThunkJava_CMShowEngineInitFinish(boolean z16) {
        GameActivityThunk.GetSingleton().CMShowEngineInitFinish(z16);
    }

    public void AndroidThunkJava_CMShowFireEventToMainProcess(int i3, String str) {
        GameActivityThunk.GetSingleton().CMShowFireEventToMainProcess(i3, str);
    }

    public int AndroidThunkJava_CMShowGetNetStatus() {
        return GameActivityThunk.GetSingleton().CMShowGetNetStatus();
    }

    public int AndroidThunkJava_CMShowGetProfile() {
        return GameActivityThunk.GetSingleton().CMShowGetProfile();
    }

    public void AndroidThunkJava_CMShowOnAvatarSaved() {
        GameActivityThunk.GetSingleton().CMShowOnAvatarSaved();
    }

    public boolean AndroidThunkJava_CMShowReport(String str, String str2, String str3, Object obj) {
        return GameActivityThunk.GetSingleton().CMShowReport(str, str2, str3, obj);
    }

    public void AndroidThunkJava_CMShowRequestLeaveAvatarShow() {
        GameActivityThunk.GetSingleton().CMShowRequestLeaveAvatarShow();
    }

    public void AndroidThunkJava_CMShowRequestShowFeedback() {
        GameActivityThunk.GetSingleton().CMShowRequestShowFeedback();
    }

    public boolean AndroidThunkJava_CMShowSend(String str, byte[] bArr) {
        return GameActivityThunk.GetSingleton().CMShowSend(str, bArr);
    }

    public void AndroidThunkJava_CMShowStartRecord(int i3, int i16) {
        GameActivityThunk.GetSingleton().CMShowStartRecord(i3, i16);
    }

    public void AndroidThunkJava_ChangeDeviceOrientation(int i3) {
        final int i16;
        Activity activity = _activity;
        if (activity == null) {
            return;
        }
        switch (i3) {
            case 0:
                i16 = 1;
                break;
            case 1:
                i16 = 9;
                break;
            case 2:
                i16 = 7;
                break;
            case 3:
                i16 = 0;
                break;
            case 4:
                i16 = 8;
                break;
            case 5:
                i16 = 6;
                break;
            case 6:
                i16 = 4;
                break;
            case 7:
                i16 = 10;
                break;
            default:
                return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.48
            @Override // java.lang.Runnable
            public void run() {
                if (GameActivity._activity == null) {
                    return;
                }
                GameActivity.Log.debug("AndroidThunkJava_ChangeDeviceOrientation: " + i16);
                GameActivity._activity.setRequestedOrientation(i16);
            }
        });
    }

    public String AndroidThunkJava_ClipboardPaste() {
        return "";
    }

    public String AndroidThunkJava_CookieManager_GetCookies(String str) {
        CookieManager cookieManager = CookieManager.getInstance();
        if (cookieManager != null) {
            cookieManager.setAcceptCookie(true);
            return cookieManager.getCookie(str);
        }
        return null;
    }

    public boolean AndroidThunkJava_CookieManager_RemoveCookies(String str) {
        CookieManager cookieManager = CookieManager.getInstance();
        if (cookieManager == null) {
            return false;
        }
        cookieManager.setAcceptCookie(true);
        if (cookieManager.getCookie(str) == null) {
            return false;
        }
        cookieManager.setCookie(str, "expires=Sat, 1 Jan 2000 00:00:01 UTC;");
        cookieManager.flush();
        return true;
    }

    public boolean AndroidThunkJava_CookieManager_SetCookie(String str, String str2) {
        CookieManager cookieManager = CookieManager.getInstance();
        if (cookieManager != null) {
            cookieManager.setAcceptCookie(true);
            cookieManager.setCookie(str, str2);
            cookieManager.flush();
            return true;
        }
        return false;
    }

    public Object AndroidThunkJava_DecodeImage2RGBA8(String str, String str2, int i3, int i16) {
        return GameActivityThunk.GetSingleton().DecodeImage2RGBA8(str, str2, i3, i16);
    }

    public void AndroidThunkJava_DisableScreenCapture(boolean z16) {
        int i3;
        boolean AndroidThunkJava_IsScreenCaptureDisabled = AndroidThunkJava_IsScreenCaptureDisabled();
        int i16 = this.NumTimesScreenCaptureDisabled;
        if (z16) {
            i3 = 1;
        } else {
            i3 = -1;
        }
        this.NumTimesScreenCaptureDisabled = i16 + i3;
        if (AndroidThunkJava_IsScreenCaptureDisabled() != AndroidThunkJava_IsScreenCaptureDisabled) {
            SetDisableScreenCaptureInternal(!AndroidThunkJava_IsScreenCaptureDisabled);
        }
    }

    public void AndroidThunkJava_DismissSplashScreen() {
        UE4.profileTimepoint();
        Dialog dialog = this.mSplashDialog;
        if (dialog != null) {
            dialog.dismiss();
            this.mSplashDialog = null;
        }
    }

    public void AndroidThunkJava_ForceQuit() {
        System.exit(0);
    }

    public String AndroidThunkJava_GetAndroidId() {
        try {
            return DeviceInfoMonitor.getString(getApplicationContext().getContentResolver(), SharedPreferencedUtil.SP_KEY_ANDROID_ID);
        } catch (Exception e16) {
            Log.debug("GetAndroidId failed: " + e16.getMessage());
            return null;
        }
    }

    public AssetManager AndroidThunkJava_GetAssetManager() {
        if (this.AssetManagerReference == null) {
            this.AssetManagerReference = getAssets();
        }
        if (this.AssetManagerReference == null) {
            Log.debug("No reference to asset manager found!");
        }
        return this.AssetManagerReference;
    }

    public String AndroidThunkJava_GetCommandLine() {
        return "";
    }

    public void AndroidThunkJava_GetCurrentContext() {
        GameActivityThunk.GetSingleton().GetCurrentContext();
    }

    public int AndroidThunkJava_GetDeviceOrientation() {
        Activity activity = _activity;
        if (activity == null) {
            Context context = _context;
            if (context != null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                if (windowManager != null) {
                    return windowManager.getDefaultDisplay().getRotation();
                }
            } else if (getBaseContext() != null) {
                int i3 = getResources().getConfiguration().orientation;
                if (i3 != 1) {
                    if (i3 != 2) {
                        return -1;
                    }
                    return 1;
                }
                return 0;
            }
            return -1;
        }
        return activity.getWindowManager().getDefaultDisplay().getRotation();
    }

    public int AndroidThunkJava_GetDisplayHeight() {
        WindowManager windowManager;
        Activity activity = _activity;
        if (activity == null) {
            Log.debug("GetDisplayHeight _activity is null");
            Context context = _context;
            if (context != null && (windowManager = (WindowManager) context.getSystemService("window")) != null) {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                int i3 = point.y;
                Log.debug("GetDisplayHeight height is " + i3);
                return i3;
            }
            return -1;
        }
        Display defaultDisplay2 = activity.getWindowManager().getDefaultDisplay();
        Point point2 = new Point();
        defaultDisplay2.getSize(point2);
        int i16 = point2.y;
        Log.debug("GetDisplayHeight height is " + i16);
        return i16;
    }

    public int AndroidThunkJava_GetDisplayOrientation() {
        Context context = _context;
        if (context != null) {
            if (context.getResources().getConfiguration().orientation == 1) {
                return 1;
            }
            if (_context.getResources().getConfiguration().orientation == 2) {
                return 2;
            }
            return 0;
        }
        return 0;
    }

    public int AndroidThunkJava_GetDisplayWidth() {
        WindowManager windowManager;
        Activity activity = _activity;
        if (activity == null) {
            Log.debug("GetDisplayWidth _activity is null");
            Context context = _context;
            if (context != null && (windowManager = (WindowManager) context.getSystemService("window")) != null) {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                int i3 = point.x;
                Log.debug("GetDisplayWidth width is " + i3);
                return i3;
            }
            return -1;
        }
        Display defaultDisplay2 = activity.getWindowManager().getDefaultDisplay();
        Point point2 = new Point();
        defaultDisplay2.getSize(point2);
        int i16 = point2.x;
        Log.debug("GetDisplayWidth width is " + i16);
        return i16;
    }

    public String AndroidThunkJava_GetFunnelId() {
        return "";
    }

    public InputDeviceInfo AndroidThunkJava_GetInputDeviceInfo(int i3) {
        String num;
        int i16;
        int i17;
        int i18;
        for (int i19 : InputDevice.getDeviceIds()) {
            InputDevice device = InputDevice.getDevice(i19);
            if (device != null && device.getId() == i3) {
                int i26 = ANDROID_BUILD_VERSION;
                if (i26 >= 16) {
                    num = device.getDescriptor();
                } else {
                    num = Integer.toString(i3);
                }
                String str = num;
                if (i26 >= 19) {
                    i16 = device.getVendorId();
                    i17 = device.getProductId();
                    i18 = device.getControllerNumber();
                    for (DeviceInfoData deviceInfoData : DeviceInfoList) {
                        if (deviceInfoData.IsMatch(i16, i17)) {
                            return new InputDeviceInfo(i3, i16, i17, i18, deviceInfoData.name, str);
                        }
                    }
                } else {
                    i16 = 0;
                    i17 = 0;
                    i18 = 0;
                }
                return new InputDeviceInfo(i3, i16, i17, i18, device.getName(), str);
            }
        }
        return new InputDeviceInfo(i3, 0, 0, -1, "Unknown", "Unknown");
    }

    public boolean AndroidThunkJava_GetIntentExtrasBoolean(String str) {
        Bundle bundle = _extrasBundle;
        if (bundle != null && str != null) {
            return bundle.getBoolean(str);
        }
        return false;
    }

    public int AndroidThunkJava_GetIntentExtrasInt(String str) {
        Bundle bundle = _extrasBundle;
        if (bundle != null && str != null) {
            return bundle.getInt(str);
        }
        return 0;
    }

    public String AndroidThunkJava_GetIntentExtrasString(String str) {
        Bundle bundle = _extrasBundle;
        if (bundle != null && str != null) {
            return bundle.getString(str);
        }
        return null;
    }

    public String AndroidThunkJava_GetLoginId() {
        if (this.InternalFilesDir != null) {
            File file = new File(this.InternalFilesDir + "login-identifier.txt");
            if (file.exists()) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    String readLine = bufferedReader.readLine();
                    bufferedReader.close();
                    return readLine;
                } catch (IOException e16) {
                    Log.debug("failed to read login-identifier.txt: " + e16);
                }
            }
        }
        if (this.ExternalFilesDir != null) {
            File file2 = new File(this.ExternalFilesDir + "login-identifier.txt");
            if (file2.exists()) {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
                    String readLine2 = bufferedReader2.readLine();
                    bufferedReader2.close();
                    String str = this.InternalFilesDir;
                    if (str != null) {
                        writeLoginId(str, readLine2);
                    }
                    return readLine2;
                } catch (IOException e17) {
                    Log.debug("failed to read login-identifier.txt: " + e17);
                }
            }
        }
        String uuid = UUID.randomUUID().toString();
        String str2 = this.InternalFilesDir;
        if (str2 != null) {
            writeLoginId(str2, uuid);
        }
        return uuid;
    }

    public boolean AndroidThunkJava_GetMetaDataBoolean(String str) {
        Bundle bundle = _bundle;
        if (bundle != null && str != null) {
            return bundle.getBoolean(str);
        }
        return false;
    }

    public float AndroidThunkJava_GetMetaDataFloat(String str) {
        if (str.equals("ue4.display.getRefreshRate")) {
            float refreshRate = ((WindowManager) getSystemService("window")).getDefaultDisplay().getRefreshRate();
            if (refreshRate < 15.0f) {
                return 60.0f;
            }
            return refreshRate;
        }
        return 0.0f;
    }

    public int AndroidThunkJava_GetMetaDataInt(String str) {
        int i3;
        if (str.equals("ue4.http.proxy.proxyPort")) {
            if (ANDROID_BUILD_VERSION >= 14) {
                String property = System.getProperty("http.proxyPort");
                if (property == null) {
                    return -1;
                }
                return Integer.parseInt(property);
            }
            return Proxy.getPort(getApplicationContext());
        }
        if (str.equals("android.hardware.vulkan.version")) {
            return this.VulkanVersion;
        }
        if (str.equals("android.hardware.vulkan.level")) {
            return this.VulkanLevel;
        }
        if (str.equals("ue4.getUsedMemory")) {
            synchronized (this) {
                i3 = this.UsedMemory;
            }
            return i3;
        }
        int i16 = 0;
        if (str.equals("audiomanager.framesPerBuffer")) {
            String property2 = ((AudioManager) getSystemService("audio")).getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
            if (property2 != null) {
                i16 = Integer.parseInt(property2);
            }
            if (i16 == 0) {
                i16 = 256;
            }
            Log.debug("[JAVA] audiomanager.framesPerBuffer = " + i16);
            return i16;
        }
        if (str.equals("audiomanager.optimalSampleRate")) {
            String property3 = ((AudioManager) getSystemService("audio")).getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
            if (property3 != null) {
                i16 = Integer.parseInt(property3);
            }
            if (i16 == 0) {
                i16 = 44100;
            }
            Log.debug("[JAVA] audiomanager.optimalSampleRate = " + i16);
            return i16;
        }
        Bundle bundle = _bundle;
        if (bundle == null) {
            return 0;
        }
        return bundle.getInt(str);
    }

    public long AndroidThunkJava_GetMetaDataLong(String str) {
        if (str.equals("ue4.display.PresentationDeadlineNanos")) {
            return ((WindowManager) getSystemService("window")).getDefaultDisplay().getPresentationDeadlineNanos();
        }
        if (str.equals("ue4.display.AppVsyncOffsetNanos")) {
            return ((WindowManager) getSystemService("window")).getDefaultDisplay().getAppVsyncOffsetNanos();
        }
        return 0L;
    }

    public String AndroidThunkJava_GetMetaDataString(String str) {
        WindowManager windowManager;
        if (str.startsWith("getprop:")) {
            return getProp(str.substring(8));
        }
        if (str.equals("ue4.http.proxy.proxyHost")) {
            if (ANDROID_BUILD_VERSION >= 14) {
                return System.getProperty("http.proxyHost");
            }
            return Proxy.getHost(getApplicationContext());
        }
        if (str.equals("ue4.displaymetrics.dpi")) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (_activity != null) {
                _activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                Context context = _context;
                if (context != null && (windowManager = (WindowManager) context.getSystemService("window")) != null) {
                    windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
                }
            }
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
            decimalFormatSymbols.setDecimalSeparator('.');
            DecimalFormat decimalFormat = new DecimalFormat("###.##", decimalFormatSymbols);
            return decimalFormat.format(displayMetrics.xdpi) + "," + decimalFormat.format(displayMetrics.ydpi) + "," + decimalFormat.format(displayMetrics.densityDpi);
        }
        Bundle bundle = _bundle;
        if (bundle != null) {
            return bundle.getString(str);
        }
        return null;
    }

    public int AndroidThunkJava_GetNativeDisplayRefreshRate() {
        float refreshRate;
        WindowManager windowManager;
        Activity activity = _activity;
        if (activity == null) {
            Context context = _context;
            if (context == null || (windowManager = (WindowManager) context.getSystemService("window")) == null || ANDROID_BUILD_VERSION < 24) {
                return 60;
            }
            refreshRate = windowManager.getDefaultDisplay().getMode().getRefreshRate();
        } else {
            if (ANDROID_BUILD_VERSION < 24) {
                return 60;
            }
            refreshRate = activity.getWindowManager().getDefaultDisplay().getMode().getRefreshRate();
        }
        return (int) refreshRate;
    }

    public int AndroidThunkJava_GetNetworkConnectionType() {
        boolean z16;
        boolean isAirplaneModeOn = isAirplaneModeOn(getApplicationContext());
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnectedOrConnecting()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return isAirplaneModeOn ? 1 : 0;
        }
        int type = NetworkMonitor.getType(activeNetworkInfo);
        if (type != 1) {
            if (type != 9) {
                if (type != 6) {
                    if (type != 7) {
                        if (isAirplaneModeOn) {
                            return 1;
                        }
                        return 3;
                    }
                    if (isAirplaneModeOn) {
                        return 1;
                    }
                    return 6;
                }
                if (isAirplaneModeOn) {
                    return 1;
                }
                return 5;
            }
            return 2;
        }
        return 4;
    }

    public int[] AndroidThunkJava_GetSupportedNativeDisplayRefreshRates() {
        WindowManager windowManager;
        Activity activity = _activity;
        int i3 = 0;
        if (activity == null) {
            Context context = _context;
            if (context != null && ANDROID_BUILD_VERSION >= 24 && (windowManager = (WindowManager) context.getSystemService("window")) != null) {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Display.Mode mode = defaultDisplay.getMode();
                Display.Mode[] supportedModes = defaultDisplay.getSupportedModes();
                ArrayList arrayList = new ArrayList();
                for (int i16 = 0; i16 < supportedModes.length; i16++) {
                    if (supportedModes[i16].getPhysicalHeight() == mode.getPhysicalHeight() && supportedModes[i16].getPhysicalWidth() == mode.getPhysicalWidth()) {
                        arrayList.add(Integer.valueOf((int) supportedModes[i16].getRefreshRate()));
                    }
                }
                if (arrayList.size() == 0) {
                    arrayList.add(60);
                }
                int size = arrayList.size();
                int[] iArr = new int[size];
                while (i3 < size) {
                    iArr[i3] = ((Integer) arrayList.get(i3)).intValue();
                    i3++;
                }
                return iArr;
            }
            return new int[]{60};
        }
        if (ANDROID_BUILD_VERSION >= 24) {
            Display defaultDisplay2 = activity.getWindowManager().getDefaultDisplay();
            Display.Mode mode2 = defaultDisplay2.getMode();
            Display.Mode[] supportedModes2 = defaultDisplay2.getSupportedModes();
            ArrayList arrayList2 = new ArrayList();
            for (int i17 = 0; i17 < supportedModes2.length; i17++) {
                if (supportedModes2[i17].getPhysicalHeight() == mode2.getPhysicalHeight() && supportedModes2[i17].getPhysicalWidth() == mode2.getPhysicalWidth()) {
                    arrayList2.add(Integer.valueOf((int) supportedModes2[i17].getRefreshRate()));
                }
            }
            if (arrayList2.size() == 0) {
                arrayList2.add(60);
            }
            int size2 = arrayList2.size();
            int[] iArr2 = new int[size2];
            while (i3 < size2) {
                iArr2[i3] = ((Integer) arrayList2.get(i3)).intValue();
                i3++;
            }
            return iArr2;
        }
        return new int[]{60};
    }

    public boolean AndroidThunkJava_HasIntentExtrasKey(String str) {
        Bundle bundle = _extrasBundle;
        if (bundle != null && str != null) {
            return bundle.containsKey(str);
        }
        return false;
    }

    public boolean AndroidThunkJava_HasJavaThunks() {
        return true;
    }

    public boolean AndroidThunkJava_HasMetaDataKey(String str) {
        Bundle bundle = _bundle;
        if (bundle != null && str != null) {
            return bundle.containsKey(str);
        }
        return false;
    }

    public void AndroidThunkJava_HideVirtualKeyboardInput() {
        Handler handler = this.virtualKeyboardHandler;
        if (handler == null) {
            UE4.logMessage("hanshuliu test VK: AndroidThunkJava_HideVirtualKeyboardInput 1");
            return;
        }
        lastVirtualKeyboardCommand = VirtualKeyboardCommand.VK_CMD_HIDE;
        handler.removeCallbacksAndMessages(null);
        this.virtualKeyboardHandler.postDelayed(new Runnable() { // from class: com.epicgames.ue4.GameActivity.31
            @Override // java.lang.Runnable
            public void run() {
                if (GameActivity.lastVirtualKeyboardCommand == VirtualKeyboardCommand.VK_CMD_HIDE) {
                    GameActivity.this.processLastVirtualKeyboardCommand();
                }
            }
        }, 200L);
    }

    public void AndroidThunkJava_HideVirtualKeyboardInputDialog() {
        if (_activity == null) {
            return;
        }
        if (!this.virtualKeyboardAlert.isShowing()) {
            Log.debug("Virtual keyboard already hidden.");
        } else {
            _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.29
                @Override // java.lang.Runnable
                public void run() {
                    if (GameActivity._activity != null && GameActivity.this.virtualKeyboardAlert.isShowing()) {
                        GameActivity.Log.debug("Virtual keyboard hiding");
                        GameActivity.this.virtualKeyboardInputBox.setText(" ");
                        GameActivity.this.virtualKeyboardAlert.dismiss();
                        GameActivity.this.CurrentDialogType = EAlertDialogType.None;
                    }
                }
            });
        }
    }

    public boolean AndroidThunkJava_IapConsumePurchase(String str) {
        Log.debug("[JAVA] - AndroidThunkJava_IapConsumePurchase " + str);
        StoreHelper storeHelper = this.IapStoreHelper;
        if (storeHelper != null) {
            storeHelper.ConsumePurchase(str);
            return true;
        }
        Log.debug("[JAVA] - Store Helper is invalid");
        return false;
    }

    public boolean AndroidThunkJava_IapIsAllowedToMakePurchases() {
        Log.debug("[JAVA] - AndroidThunkJava_IapIsAllowedToMakePurchases");
        StoreHelper storeHelper = this.IapStoreHelper;
        if (storeHelper != null) {
            return storeHelper.IsAllowedToMakePurchases();
        }
        Log.debug("[JAVA] - Store Helper is invalid");
        return false;
    }

    public boolean AndroidThunkJava_IapQueryExistingPurchases() {
        Log.debug("[JAVA] - AndroidThunkJava_IapQueryExistingPurchases");
        if (this.IapStoreHelper != null) {
            Log.debug("[JAVA] - AndroidThunkJava_IapQueryExistingPurchases - Kick off logic here!");
            return this.IapStoreHelper.QueryExistingPurchases();
        }
        Log.debug("[JAVA] - Store Helper is invalid");
        return false;
    }

    public boolean AndroidThunkJava_IapQueryInAppPurchases(String[] strArr) {
        Log.debug("[JAVA] - AndroidThunkJava_IapQueryInAppPurchases");
        this.CachedQueryProductIDs = strArr;
        if (this.IapStoreHelper != null) {
            Runnable runnable = new Runnable() { // from class: com.epicgames.ue4.GameActivity.36
                @Override // java.lang.Runnable
                public void run() {
                    GameActivity.this.IapStoreHelper.QueryInAppPurchases(GameActivity.this.CachedQueryProductIDs);
                }
            };
            Activity activity = _activity;
            if (activity != null) {
                activity.runOnUiThread(runnable);
            } else {
                _UIHandler.post(runnable);
            }
            return true;
        }
        Log.debug("[JAVA] - Store Helper is invalid");
        return false;
    }

    public boolean AndroidThunkJava_IapRestorePurchases(String[] strArr, boolean[] zArr) {
        Log.debug("[JAVA] - AndroidThunkJava_IapRestorePurchases");
        if (this.IapStoreHelper != null) {
            Log.debug("[JAVA] - AndroidThunkJava_IapRestorePurchases - Kick off logic here!");
            return this.IapStoreHelper.RestorePurchases(strArr, zArr);
        }
        Log.debug("[JAVA] - Store Helper is invalid");
        return false;
    }

    public void AndroidThunkJava_InitHMDs() {
        Activity activity = _activity;
        if (activity == null) {
            _UIHandler.post(new Runnable() { // from class: com.epicgames.ue4.GameActivity.34
                @Override // java.lang.Runnable
                public void run() {
                    GameActivity.this.nativeInitHMDs();
                }
            });
        } else {
            activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.35
                @Override // java.lang.Runnable
                public void run() {
                    GameActivity.this.nativeInitHMDs();
                }
            });
        }
    }

    public boolean AndroidThunkJava_IsAllowedRemoteNotifications() {
        return false;
    }

    public boolean AndroidThunkJava_IsDisplayPortrait() {
        if (AndroidThunkJava_GetDisplayOrientation() == 1) {
            return true;
        }
        return false;
    }

    public boolean AndroidThunkJava_IsGamepadAttached() {
        for (int i3 : InputDevice.getDeviceIds()) {
            InputDevice device = InputDevice.getDevice(i3);
            if ((device.getSources() & 1025) == 1025 || (device.getSources() & 16777232) == 16777232) {
                return true;
            }
        }
        return false;
    }

    public boolean AndroidThunkJava_IsMusicActive() {
        return ((AudioManager) getSystemService("audio")).isMusicActive();
    }

    public boolean AndroidThunkJava_IsPackageInstalled(String str) {
        return getInstalledPackages(getApplicationContext()).contains(str);
    }

    public boolean AndroidThunkJava_IsScreenCaptureDisabled() {
        if (this.NumTimesScreenCaptureDisabled != 0) {
            return true;
        }
        return false;
    }

    public boolean AndroidThunkJava_IsScreensaverEnabled() {
        return !this.bKeepScreenOn;
    }

    public void AndroidThunkJava_KeepScreenOn(boolean z16) {
        Activity activity = _activity;
        if (activity == null) {
            return;
        }
        this.bKeepScreenOn = z16;
        if (z16) {
            activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.23
                @Override // java.lang.Runnable
                public void run() {
                    if (GameActivity._activity == null) {
                        return;
                    }
                    GameActivity.Log.debug("==============> [JAVA] AndroidThunkJava_KeepScreenOn(true) - Disabled screen saver");
                    GameActivity._activity.getWindow().addFlags(128);
                }
            });
        } else {
            activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.24
                @Override // java.lang.Runnable
                public void run() {
                    if (GameActivity._activity == null) {
                        return;
                    }
                    GameActivity.Log.debug("==============> [JAVA] AndroidThunkJava_KeepScreenOn(false) - Enabled screen saver");
                    GameActivity._activity.getWindow().clearFlags(128);
                }
            });
        }
    }

    public boolean AndroidThunkJava_LaunchPackage(String str, String str2, String str3) {
        return false;
    }

    public void AndroidThunkJava_LaunchURL(String str) {
        Log.debug("[JAVA} AndroidThunkJava_LaunchURL: URL = " + str);
        if (!str.contains(QzoneWebViewOfflinePlugin.STR_DEVIDER) && str.indexOf(":") < 1) {
            str = "http://" + str;
            Log.debug("[JAVA} AndroidThunkJava_LaunchURL: corrected URL = " + str);
        }
        try {
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str));
            intent.addFlags(1074266112);
            intent.addFlags(402653184);
            if (intent.resolveActivity(getPackageManager()) != null) {
                Log.debug("[JAVA} AndroidThunkJava_LaunchURL: Starting activity");
                startActivity(intent);
            } else {
                Log.debug("[JAVA} AndroidThunkJava_LaunchURL: Could not find an application to receive the URL intent");
            }
        } catch (Exception e16) {
            Log.debug("[JAVA} AndroidThunkJava_LaunchURL: Failed with exception " + e16.getMessage());
        }
    }

    public void AndroidThunkJava_LocalNotificationClearAll() {
        Iterator<Integer> it = LocalNotificationGetIDList().iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            AlarmManager alarmManager = (AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM);
            PendingIntent broadcast = PendingIntent.getBroadcast(this, intValue, new Intent(this, (Class<?>) LocalNotificationReceiver.class), 134217728);
            broadcast.cancel();
            alarmManager.cancel(broadcast);
        }
        SharedPreferences.Editor edit = getApplicationContext().getSharedPreferences("LocalNotificationPreferences", 0).edit();
        edit.putString("notificationIDs", "");
        edit.putString("notificationDetails", "{}");
        edit.commit();
    }

    public boolean AndroidThunkJava_LocalNotificationDestroyIfExists(int i3) {
        if (AndroidThunkJava_LocalNotificationExists(i3)) {
            LocalNotificationRemoveID(this, i3);
            LocalNotificationRemoveDetails(this, i3);
            AlarmManager alarmManager = (AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM);
            PendingIntent broadcast = PendingIntent.getBroadcast(this, i3, new Intent(this, (Class<?>) LocalNotificationReceiver.class), 134217728);
            broadcast.cancel();
            alarmManager.cancel(broadcast);
            ((NotificationManager) getSystemService("notification")).cancel(i3);
            return true;
        }
        return false;
    }

    public boolean AndroidThunkJava_LocalNotificationExists(int i3) {
        return LocalNotificationIDExists(i3);
    }

    public LaunchNotification AndroidThunkJava_LocalNotificationGetLaunchNotification() {
        return new LaunchNotification(this.localNotificationAppLaunched, this.localNotificationLaunchActivationEvent, this.localNotificationLaunchFireDate);
    }

    public int AndroidThunkJava_LocalNotificationScheduleAtTime(String str, boolean z16, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject;
        int LocalNotificationGetID = LocalNotificationGetID(this);
        if (!LocalNotificationScheduleAtTime(this, LocalNotificationGetID, str, z16, str2, str3, str4, str5)) {
            return -1;
        }
        SharedPreferences sharedPreferences = getSharedPreferences("LocalNotificationPreferences", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        try {
            jSONObject = new JSONObject(sharedPreferences.getString("notificationDetails", "{}"));
        } catch (JSONException e16) {
            e16.printStackTrace();
            jSONObject = new JSONObject();
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("local-notification-targetDateTime", str);
            jSONObject2.put("local-notification-localTime", z16);
            jSONObject2.put(LocalNotificationReceiver.KEY_LOCAL_NOTIFICATION_TITLE, str2);
            jSONObject2.put(LocalNotificationReceiver.KEY_LOCAL_NOTIFICATION_BODY, str3);
            jSONObject2.put(LocalNotificationReceiver.KEY_LOCAL_NOTIFICATION_ACTION, str4);
            jSONObject2.put(LocalNotificationReceiver.KEY_LOCAL_NOTIFICATION_ACTION_EVENT, str5);
            jSONObject.put(String.valueOf(LocalNotificationGetID), jSONObject2);
            edit.putString("notificationDetails", jSONObject.toString());
            edit.commit();
        } catch (JSONException e17) {
            e17.printStackTrace();
        }
        return LocalNotificationGetID;
    }

    public String AndroidThunkJava_LuaBridgeOnLuaEvent(String str, String str2, int i3) {
        return GameActivityThunk.GetSingleton().OnLuaEvent(str, str2, i3);
    }

    public void AndroidThunkJava_Minimize() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(268435456);
        startActivity(intent);
    }

    public void AndroidThunkJava_OnEngineActivated() {
        UE4.onEngineActivated();
    }

    public void AndroidThunkJava_OnEngineBooted() {
        UE4.onEngineBooted();
    }

    public void AndroidThunkJava_OnEngineInited(boolean z16) {
        UE4.onEngineInited(z16);
    }

    public void AndroidThunkJava_OnEnginePurged() {
        UE4.onEnginePurged();
    }

    public void AndroidThunkJava_OnEnginePurging() {
        UE4.onEnginePurging();
    }

    public void AndroidThunkJava_OnEngineRecovered() {
        UE4.onEngineRecovered();
    }

    public void AndroidThunkJava_OnEngineRecovering() {
        UE4.onEngineRecovering();
    }

    public void AndroidThunkJava_OnEngineSuspended() {
        UE4.onEngineSuspended();
    }

    public void AndroidThunkJava_OnEngineWindowTerminated() {
        UE4.onEngineWindowTerminated();
    }

    public void AndroidThunkJava_OnFingerTaps(int i3) {
        UE4.onFingerTaps(i3);
    }

    public void AndroidThunkJava_OnFrameTickCallback(long j3, int i3) {
        GameActivityThunk.GetSingleton().OnFrameTickCallback(j3, i3);
    }

    public void AndroidThunkJava_OnRecordSameStyleAudioFrame(int i3, byte[] bArr, int i16, int i17) {
        GameActivityThunk.GetSingleton().OnRecordSameStyleAudioFrame(i3, bArr, i16, i17);
    }

    public void AndroidThunkJava_OnRecordSameStyleEnd(int i3) {
        GameActivityThunk.GetSingleton().OnRecordSameStyleEnd(i3);
    }

    public int AndroidThunkJava_OnRecordSameStyleStart(int i3, int i16, int i17, int i18, int i19, int i26, String str) {
        Log.debug("gameActivityClassAdditions::AndroidThunkJava_OnRecordSameStyleStart");
        return GameActivityThunk.GetSingleton().OnRecordSameStyleStart(i3, i16, i17, i18, i19, i26, str);
    }

    public void AndroidThunkJava_OnRecordSameStyleVideoFrame(int i3, byte[] bArr, int i16, int i17) {
        GameActivityThunk.GetSingleton().OnRecordSameStyleVideoFrame(i3, bArr, i16, i17);
    }

    public void AndroidThunkJava_OpenIntentAction(String str) {
        Intent intent = new Intent(str, (Uri) null);
        intent.addFlags(268435456);
        startActivity(intent);
    }

    public void AndroidThunkJava_OpenLightAIPhotoSelector() {
        GameActivityThunk.GetSingleton().OpenLightAIPhotoSelector();
    }

    public boolean AndroidThunkJava_ParallelWorldCanDrawRenderTarget(int i3, int i16) {
        UE4.ParallelWorldListener parallelWorldListener = UE4.ParallelWorld.listener;
        if (parallelWorldListener != null) {
            return parallelWorldListener.canDrawRenderTarget(i3, i16);
        }
        return false;
    }

    public void AndroidThunkJava_ParallelWorldDrawRenderTargetAsFramebuffer(int i3, int i16, int i17, int i18) {
        UE4.ParallelWorldListener parallelWorldListener = UE4.ParallelWorld.listener;
        if (parallelWorldListener != null) {
            parallelWorldListener.drawRenderTargetAsFramebuffer(i3, i16, i17, i18);
        }
    }

    public void AndroidThunkJava_ParallelWorldDrawRenderTargetAsPixels(int i3, byte[] bArr, int i16, int i17) {
        UE4.ParallelWorldListener parallelWorldListener = UE4.ParallelWorld.listener;
        if (parallelWorldListener != null) {
            parallelWorldListener.drawRenderTargetAsPixels(i3, bArr, i16, i17);
        }
    }

    public void AndroidThunkJava_ParallelWorldOnActivated(int i3, boolean z16, int i16, int i17) {
        UE4.ParallelWorldListener parallelWorldListener = UE4.ParallelWorld.listener;
        if (parallelWorldListener != null) {
            parallelWorldListener.onActivated(i3, z16, i16, i17);
        }
    }

    public void AndroidThunkJava_ParallelWorldOnDeactivated(int i3) {
        UE4.ParallelWorldListener parallelWorldListener = UE4.ParallelWorld.listener;
        if (parallelWorldListener != null) {
            parallelWorldListener.onDeactivated(i3);
        }
    }

    public void AndroidThunkJava_ParallelWorldOnDrawModeChanged(int i3, int i16, int i17) {
        UE4.ParallelWorldListener parallelWorldListener = UE4.ParallelWorld.listener;
        if (parallelWorldListener != null) {
            parallelWorldListener.onDrawModeChanged(i3, i16, i17);
        }
    }

    public void AndroidThunkJava_ParallelWorldOnFocusChanged(int i3, int i16) {
        UE4.ParallelWorld.focusedID = i16;
        UE4.ParallelWorldListener parallelWorldListener = UE4.ParallelWorld.listener;
        if (parallelWorldListener != null) {
            parallelWorldListener.onFocusChanged(i3, i16);
        }
    }

    public void AndroidThunkJava_ParallelWorldOnInited(int i3) {
        UE4.ParallelWorldListener parallelWorldListener = UE4.ParallelWorld.listener;
        if (parallelWorldListener != null) {
            parallelWorldListener.onInited(i3);
        }
    }

    public void AndroidThunkJava_ParallelWorldOnKilled(int i3) {
        UE4.ParallelWorldListener parallelWorldListener = UE4.ParallelWorld.listener;
        if (parallelWorldListener != null) {
            parallelWorldListener.onKilled(i3);
        }
    }

    public void AndroidThunkJava_ParallelWorldOnLoaded(int i3, boolean z16) {
        UE4.ParallelWorldListener parallelWorldListener = UE4.ParallelWorld.listener;
        if (parallelWorldListener != null) {
            parallelWorldListener.onLoaded(i3, z16);
        }
    }

    public void AndroidThunkJava_ParallelWorldOnNativeWindowChanged(int i3) {
        UE4.ParallelWorldListener parallelWorldListener = UE4.ParallelWorld.listener;
        if (parallelWorldListener != null) {
            parallelWorldListener.onNativeWindowChanged(i3);
        }
    }

    public void AndroidThunkJava_PushSensorEvents() {
        if (this.bAllowIMU) {
            synchronized (this) {
                if (this.bSensorDataUpdated) {
                    nativeHandleSensorEvents(this.current_tilt, current_rotation_rate, current_gravity, current_acceleration);
                    this.bSensorDataUpdated = false;
                }
            }
        }
    }

    public void AndroidThunkJava_RequestDisplayConfiguration() {
        if (!GameActivityBase.bAllowDisplayConfigurationRequest) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.epicgames.ue4.GameActivity.47
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                if (!GameActivityBase.bAllowDisplayConfigurationRequest) {
                    return;
                }
                boolean AndroidThunkJava_IsDisplayPortrait = GameActivity.this.AndroidThunkJava_IsDisplayPortrait();
                int AndroidThunkJava_GetDisplayWidth = GameActivity.this.AndroidThunkJava_GetDisplayWidth();
                int AndroidThunkJava_GetDisplayHeight = GameActivity.this.AndroidThunkJava_GetDisplayHeight();
                if (AndroidThunkJava_GetDisplayWidth != AndroidThunkJava_GetDisplayHeight) {
                    if (AndroidThunkJava_GetDisplayWidth < AndroidThunkJava_GetDisplayHeight) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (AndroidThunkJava_IsDisplayPortrait != z16) {
                        GameActivity.Log.debug("Portrait " + AndroidThunkJava_IsDisplayPortrait + " mismatch (width:" + AndroidThunkJava_GetDisplayWidth + " height: " + AndroidThunkJava_GetDisplayHeight + ")");
                    }
                }
                GameActivityNative.OnPortraitOrientationChanged(GameActivity.this.AndroidThunkJava_IsDisplayPortrait(), GameActivity.this.AndroidThunkJava_GetDisplayWidth(), GameActivity.this.AndroidThunkJava_GetDisplayHeight());
            }
        };
        Activity activity = _activity;
        if (activity != null) {
            activity.runOnUiThread(runnable);
        } else {
            _UIHandler.post(runnable);
        }
    }

    public void AndroidThunkJava_ResetAchievements() {
        Log.debug("AndroidThunkJava_ResetAchievements: disabled");
    }

    public void AndroidThunkJava_RestartApplication(final String str) {
        Runnable runnable = new Runnable() { // from class: com.epicgames.ue4.GameActivity.46
            @Override // java.lang.Runnable
            public void run() {
                GameActivity.this.RestartApplication(str);
            }
        };
        Log.debug("app restart : " + str);
        Activity activity = _activity;
        if (activity != null) {
            activity.runOnUiThread(runnable);
        } else {
            _UIHandler.post(runnable);
        }
        while (true) {
            try {
                LockMethodProxy.sleep(Long.MAX_VALUE);
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
        }
    }

    public boolean AndroidThunkJava_SendBroadcast(String str, String str2, String str3, boolean z16) {
        return true;
    }

    public void AndroidThunkJava_SetDesiredViewSize(int i3, int i16) {
        UE4.setBackbufferSize(i3, i16);
        if (i3 == this.DesiredHolderWidth && i16 == this.DesiredHolderHeight) {
            return;
        }
        Log.debug("[JAVA] - SetDesiredViewSize width=" + i3 + " and height=" + i16);
        this.DesiredHolderWidth = i3;
        this.DesiredHolderHeight = i16;
        if (this.bUseSurfaceView && this.MySurfaceView != null) {
            Runnable runnable = new Runnable() { // from class: com.epicgames.ue4.GameActivity.40
                @Override // java.lang.Runnable
                public void run() {
                    GameActivity.this.MySurfaceView.getHolder().setFixedSize(GameActivity.this.DesiredHolderWidth, GameActivity.this.DesiredHolderHeight);
                }
            };
            Activity activity = _activity;
            if (activity != null) {
                activity.runOnUiThread(runnable);
            } else {
                _UIHandler.post(runnable);
            }
        }
    }

    public boolean AndroidThunkJava_SetNativeDisplayRefreshRate(int i3) {
        WindowManager windowManager;
        Activity activity = _activity;
        if (activity == null) {
            Context context = _context;
            if (context != null && ANDROID_BUILD_VERSION >= 24 && (windowManager = (WindowManager) context.getSystemService("window")) != null) {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Display.Mode mode = defaultDisplay.getMode();
                int modeId = mode.getModeId();
                Display.Mode[] supportedModes = defaultDisplay.getSupportedModes();
                for (int i16 = 0; i16 < supportedModes.length; i16++) {
                    if (supportedModes[i16].getPhysicalHeight() == mode.getPhysicalHeight() && supportedModes[i16].getPhysicalWidth() == mode.getPhysicalWidth() && ((int) supportedModes[i16].getRefreshRate()) == i3) {
                        final int modeId2 = supportedModes[i16].getModeId();
                        if (modeId != modeId2) {
                            _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.41
                                @Override // java.lang.Runnable
                                public void run() {
                                    Window window = GameActivity._activity.getWindow();
                                    WindowManager.LayoutParams attributes = window.getAttributes();
                                    attributes.preferredDisplayModeId = modeId2;
                                    window.setAttributes(attributes);
                                }
                            });
                            Log.debug("Found mode " + modeId2 + " for native refresh rate " + i3);
                        }
                        return true;
                    }
                }
            }
            if (i3 != 60) {
                return false;
            }
            return true;
        }
        if (ANDROID_BUILD_VERSION >= 24) {
            Display defaultDisplay2 = activity.getWindowManager().getDefaultDisplay();
            Display.Mode mode2 = defaultDisplay2.getMode();
            int modeId3 = mode2.getModeId();
            Display.Mode[] supportedModes2 = defaultDisplay2.getSupportedModes();
            for (int i17 = 0; i17 < supportedModes2.length; i17++) {
                if (supportedModes2[i17].getPhysicalHeight() == mode2.getPhysicalHeight() && supportedModes2[i17].getPhysicalWidth() == mode2.getPhysicalWidth() && ((int) supportedModes2[i17].getRefreshRate()) == i3) {
                    final int modeId4 = supportedModes2[i17].getModeId();
                    if (modeId3 != modeId4) {
                        _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.42
                            @Override // java.lang.Runnable
                            public void run() {
                                if (GameActivity._activity == null) {
                                    return;
                                }
                                Window window = GameActivity._activity.getWindow();
                                WindowManager.LayoutParams attributes = window.getAttributes();
                                attributes.preferredDisplayModeId = modeId4;
                                window.setAttributes(attributes);
                            }
                        });
                        Log.debug("Found mode " + modeId4 + " for native refresh rate " + i3);
                    }
                    return true;
                }
            }
            return false;
        }
        if (i3 != 60) {
            return false;
        }
        return true;
    }

    public void AndroidThunkJava_SetSustainedPerformanceMode(final boolean z16) {
        if (_activity == null) {
            return;
        }
        if (ANDROID_BUILD_VERSION >= 24) {
            Log.debug("==================================> SetSustainedPerformanceMode:" + z16);
            _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.43
                @Override // java.lang.Runnable
                public void run() {
                    if (GameActivity._activity == null) {
                        return;
                    }
                    try {
                        Window.class.getMethod("setSustainedPerformanceMode", Boolean.TYPE).invoke(GameActivity._activity.getWindow(), Boolean.valueOf(z16));
                    } catch (Exception e16) {
                        GameActivity.Log.debug("SetSustainedPerformanceMode: failed " + e16.getMessage());
                    }
                }
            });
            return;
        }
        Log.debug("==================================> API<24, cannot use SetSustainedPerformanceMode");
    }

    public void AndroidThunkJava_ShareURL(String str, String str2, String str3, int i3, int i16) {
        Log.debug("[JAVA} AndroidThunkJava_ShareURL: URL = " + str);
        File file = new File(str);
        boolean exists = file.exists();
        if (!exists && !str.contains(QzoneWebViewOfflinePlugin.STR_DEVIDER)) {
            str = "http://" + str;
            Log.debug("[JAVA} AndroidThunkJava_ShareURL: corrected URL = " + str);
        }
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            if (exists) {
                intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(this, getApplicationContext().getPackageName() + ".fileprovider", file));
                intent.setType(URLConnection.guessContentTypeFromName(str));
                intent.putExtra("android.intent.extra.TEXT", str2);
            } else {
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.SUBJECT", str2);
                intent.putExtra("android.intent.extra.TEXT", str);
            }
            Log.debug("[JAVA} AndroidThunkJava_ShareURL: Sharing URL");
            startActivity(Intent.createChooser(intent, str3));
        } catch (Exception e16) {
            Log.debug("[JAVA} AndroidThunkJava_ShareURL: Failed with exception " + e16.getMessage());
        }
    }

    public void AndroidThunkJava_ShowConsoleWindow(String str) {
        if (_activity == null) {
            return;
        }
        if (this.consoleAlert.isShowing()) {
            Log.debug("Console already showing.");
            return;
        }
        this.consoleHistoryIndex = this.consoleHistoryList.size();
        this.consoleAlert.setMessage("[Available texture formats: " + str + "]");
        Runnable runnable = new Runnable() { // from class: com.epicgames.ue4.GameActivity.28
            @Override // java.lang.Runnable
            public void run() {
                if (!GameActivity.this.consoleAlert.isShowing()) {
                    GameActivity.Log.debug("Console not showing yet");
                    GameActivity.this.consoleAlert.show();
                    GameActivity.this.CurrentDialogType = EAlertDialogType.Console;
                }
            }
        };
        Activity activity = _activity;
        if (activity != null) {
            activity.runOnUiThread(runnable);
        } else {
            _UIHandler.post(runnable);
        }
    }

    public void AndroidThunkJava_ShowHiddenAlertDialog() {
        if (_activity != null && this.CurrentDialogType != EAlertDialogType.None) {
            Log.debug("==============> [JAVA] AndroidThunkJava_ShowHiddenAlertDialog() - Showing " + this.CurrentDialogType);
            _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.22
                @Override // java.lang.Runnable
                public void run() {
                    if (GameActivity._activity == null) {
                        return;
                    }
                    int i3 = AnonymousClass49.$SwitchMap$com$epicgames$ue4$GameActivity$EAlertDialogType[GameActivity.this.CurrentDialogType.ordinal()];
                    if (i3 != 1) {
                        if (i3 != 2) {
                            GameActivity.Log.debug("ERROR: Unknown EAlertDialogType!");
                            return;
                        } else {
                            GameActivity.this.consoleAlert.show();
                            return;
                        }
                    }
                    GameActivity.this.virtualKeyboardAlert.show();
                }
            });
        }
    }

    public void AndroidThunkJava_ShowProgressDialog(final boolean z16, final String str, final boolean z17, final int i3) {
        Activity activity = _activity;
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.37
            @Override // java.lang.Runnable
            public void run() {
                if (z16) {
                    GameActivity.this.mProgressDialog = new ReportProgressDialog(GameActivity._activity);
                    GameActivity.this.mProgressDialog.setMessage(str);
                    GameActivity.this.mProgressDialog.setProgress(0);
                    GameActivity.this.mProgressDialog.setMax(i3);
                    GameActivity.this.mProgressDialog.setProgressStyle(z17 ? 1 : 0);
                    GameActivity.this.mProgressDialog.getWindow().setFlags(8, 8);
                    GameActivity.this.mProgressDialog.show();
                    return;
                }
                GameActivity.this.mProgressDialog.dismiss();
                GameActivity.this.mProgressDialog = null;
            }
        });
    }

    public void AndroidThunkJava_ShowVirtualKeyboardInput(int i3, String str, String str2) {
        UE4.logMessage("hanshuliu test VK: AndroidThunkJava_ShowVirtualKeyboardInput 1");
        if (this.virtualKeyboardHandler == null) {
            UE4.logMessage("hanshuliu test VK: AndroidThunkJava_ShowVirtualKeyboardInput 2");
            return;
        }
        UE4.logMessage("hanshuliu test VK: AndroidThunkJava_ShowVirtualKeyboardInput 3");
        this.virtualKeyboardInputContent = str2;
        this.virtualKeyboardInputType = i3;
        lastVirtualKeyboardCommand = VirtualKeyboardCommand.VK_CMD_SHOW;
        this.virtualKeyboardHandler.removeCallbacksAndMessages(null);
        this.virtualKeyboardHandler.postDelayed(new Runnable() { // from class: com.epicgames.ue4.GameActivity.32
            @Override // java.lang.Runnable
            public void run() {
                UE4.logMessage("hanshuliu test VK: AndroidThunkJava_ShowVirtualKeyboardInput run() 1");
                if (GameActivity.lastVirtualKeyboardCommand == VirtualKeyboardCommand.VK_CMD_SHOW) {
                    UE4.logMessage("hanshuliu test VK: AndroidThunkJava_ShowVirtualKeyboardInput run() 2");
                    GameActivity.this.processLastVirtualKeyboardCommand();
                    UE4.logMessage("hanshuliu test VK: AndroidThunkJava_ShowVirtualKeyboardInput run() 3");
                }
            }
        }, 200L);
    }

    public void AndroidThunkJava_ShowVirtualKeyboardInputDialog(final int i3, final String str, final String str2) {
        if (_activity == null) {
            return;
        }
        if (this.virtualKeyboardAlert.isShowing()) {
            Log.debug("Virtual keyboard already showing.");
        } else {
            _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.30
                @Override // java.lang.Runnable
                public void run() {
                    PasswordTransformationMethod passwordTransformationMethod;
                    if (GameActivity._activity == null) {
                        return;
                    }
                    GameActivity.this.virtualKeyboardAlert.setTitle(str);
                    GameActivity.this.virtualKeyboardInputBox.setRawInputType(i3);
                    EditText editText = GameActivity.this.virtualKeyboardInputBox;
                    if ((i3 & 128) == 0) {
                        passwordTransformationMethod = null;
                    } else {
                        passwordTransformationMethod = PasswordTransformationMethod.getInstance();
                    }
                    editText.setTransformationMethod(passwordTransformationMethod);
                    GameActivity.this.virtualKeyboardInputBox.setText("");
                    GameActivity.this.virtualKeyboardInputBox.append(str2);
                    GameActivity gameActivity = GameActivity.this;
                    gameActivity.virtualKeyboardPreviousContents = str2;
                    if (!gameActivity.virtualKeyboardAlert.isShowing()) {
                        GameActivity.Log.debug("Virtual keyboard not showing yet");
                        GameActivity.this.virtualKeyboardAlert.show();
                        GameActivity.this.CurrentDialogType = EAlertDialogType.Keyboard;
                    }
                }
            });
        }
    }

    public void AndroidThunkJava_UpdateProgressDialog(final int i3) {
        Activity activity = _activity;
        if (activity == null || this.mProgressDialog == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.38
            @Override // java.lang.Runnable
            public void run() {
                ProgressDialog progressDialog;
                if (GameActivity._activity != null && (progressDialog = GameActivity.this.mProgressDialog) != null) {
                    progressDialog.setProgress(i3);
                }
            }
        });
    }

    public void AndroidThunkJava_UseSurfaceViewWorkaround() {
        if (this.bUseSurfaceView) {
            return;
        }
        this.bUseSurfaceView = true;
        Log.debug("[JAVA] Using SurfaceView sizing workaround for this device");
        if (this.DesiredHolderWidth > 0 && this.DesiredHolderHeight > 0 && this.MySurfaceView != null) {
            Runnable runnable = new Runnable() { // from class: com.epicgames.ue4.GameActivity.39
                @Override // java.lang.Runnable
                public void run() {
                    GameActivity.this.MySurfaceView.getHolder().setFixedSize(GameActivity.this.DesiredHolderWidth, GameActivity.this.DesiredHolderHeight);
                }
            };
            Activity activity = _activity;
            if (activity != null) {
                activity.runOnUiThread(runnable);
            } else {
                _UIHandler.post(runnable);
            }
        }
    }

    public void AndroidThunkJava_Vibrate(final int i3) {
        final Vibrator vibrator = (Vibrator) getSystemService("vibrator");
        if (vibrator != null) {
            Activity activity = _activity;
            if (activity == null) {
                _UIHandler.post(new Runnable() { // from class: com.epicgames.ue4.GameActivity.27
                    @Override // java.lang.Runnable
                    public void run() {
                        new VibrateRunnable(i3, vibrator);
                    }
                });
            } else {
                activity.runOnUiThread(new VibrateRunnable(i3, vibrator));
            }
        }
    }

    public boolean AndroidThunkJava_VirtualInputIgnoreClick(int i3, int i16) {
        Activity activity = _activity;
        if (activity == null) {
            return false;
        }
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == this.newVirtualKeyboardInput) {
            Rect rect = new Rect();
            currentFocus.getGlobalVisibleRect(rect);
            if (rect.contains(i3, i16) || this.newVirtualKeyboardInput.getY() < 0.0f) {
                return true;
            }
        } else {
            List<View> GetExtraIgnoreViews = GetExtraIgnoreViews();
            if (GetExtraIgnoreViews != null) {
                for (int i17 = 0; i17 < GetExtraIgnoreViews.size(); i17++) {
                    Rect rect2 = new Rect();
                    GetExtraIgnoreViews.get(i17).getGlobalVisibleRect(rect2);
                    if (rect2.contains(i3, i16)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    protected String FindLineFromStatus(String str) {
        String readLine;
        File file = new File("/proc/self/status");
        if (file.exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                do {
                    try {
                        readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            bufferedReader.close();
                            return "";
                        }
                    } finally {
                    }
                } while (!readLine.contains(str));
                bufferedReader.close();
                return readLine;
            } catch (IOException e16) {
                Log.debug("failed to read status: " + e16);
                return "";
            }
        }
        return "";
    }

    protected FrameLayout GetContainerFrameLayout() {
        return this.containerFrameLayout;
    }

    protected List<View> GetExtraIgnoreViews() {
        return null;
    }

    public View GetMainView() {
        return this.mainView;
    }

    protected Rect GetSafezone() {
        return this.safezone;
    }

    public boolean IsInVRMode() {
        return this.IsInVRMode;
    }

    public void ParseCommandline(String str, boolean z16) {
        String str2;
        if (this.bHaveParsedCommandline) {
            return;
        }
        this.bHaveParsedCommandline = true;
        String AndroidThunkJava_GetCommandLine = AndroidThunkJava_GetCommandLine();
        if (!TextUtils.isEmpty(AndroidThunkJava_GetCommandLine)) {
            Log.debug("Using alternative commandline source");
            this.CommandLineFull = AndroidThunkJava_GetCommandLine;
            parseCommandLineParams(AndroidThunkJava_GetCommandLine);
            return;
        }
        if (z16) {
            str2 = getExternalFilesDirAbsolutePath();
            if (nativeIsShippingBuild()) {
                str2 = getFilesDirAbsolutePath();
            }
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        String str3 = str2 + "/UE4Game/" + str + "/UE4CommandLine.txt";
        BufferedReader TryOpenFileReader = TryOpenFileReader(str3);
        if (TryOpenFileReader == null) {
            str3 = str2 + "/UE4Game/" + str + "/ue4commandline.txt";
            TryOpenFileReader = TryOpenFileReader(str3);
        }
        if (TryOpenFileReader == null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.AssetManagerReference.open("UE4CommandLine.txt")));
                try {
                    Log.debug("Using APK commandline");
                } catch (FileNotFoundException | IOException unused) {
                }
                TryOpenFileReader = bufferedReader;
            } catch (FileNotFoundException | IOException unused2) {
            }
        } else {
            Log.debug("Using commandline from: " + str3);
        }
        if (TryOpenFileReader != null) {
            try {
                String readLine = TryOpenFileReader.readLine();
                if (readLine != null) {
                    String trim = readLine.trim();
                    if (trim.length() > 0) {
                        this.CommandLineFull = trim;
                        parseCommandLineParams(trim);
                    }
                }
            } catch (IOException e16) {
                Log.debug("failed to read commandline: " + e16);
            }
            try {
                TryOpenFileReader.close();
            } catch (IOException unused3) {
            }
        }
    }

    @Override // com.epicgames.ue4.GameActivityBase
    public void acquireSensors() {
        if (!UEAppStatusManager.getInstance().appForeground()) {
            UE4.logMessage("GameActivity.acquireSensors: Ignored, app in background.");
            return;
        }
        if (!this.bAllowIMU) {
            UE4.logMessage("GameActivity.acquireSensors: Ignored, since bAllowIMU is false");
            return;
        }
        if (this.accelerometer == null && this.magnetometer == null && this.gyroscope == null) {
            SensorManager sensorManager = this.sensorManager;
            if (sensorManager == null) {
                UE4.logMessage("GameActivity.acquireSensors: Failed, since sensorManager is null.");
                return;
            }
            this.accelerometer = SensorMonitor.getDefaultSensor(sensorManager, 1);
            this.magnetometer = SensorMonitor.getDefaultSensor(this.sensorManager, 2);
            Sensor defaultSensor = SensorMonitor.getDefaultSensor(this.sensorManager, 4);
            this.gyroscope = defaultSensor;
            if (this.accelerometer == null && this.magnetometer == null && defaultSensor == null) {
                UE4.logMessage("GameActivity.acquireSensors: Failed, no sensors are acquired successfully.");
                return;
            }
            UE4.logMessage("GameActivity.acquireSensors: Registering sensor listeners");
            Sensor sensor = this.accelerometer;
            if (sensor != null) {
                SensorMonitor.registerListener(this.sensorManager, this, sensor, 1);
            }
            Sensor sensor2 = this.magnetometer;
            if (sensor2 != null) {
                SensorMonitor.registerListener(this.sensorManager, this, sensor2, 1);
            }
            Sensor sensor3 = this.gyroscope;
            if (sensor3 != null) {
                SensorMonitor.registerListener(this.sensorManager, this, sensor3, 1);
                return;
            }
            return;
        }
        UE4.logMessage("GameActivity.acquireSensors: Ignored, since sensors are already acquired.");
    }

    protected View createContentView() {
        if (this._bCreateView || this.containerFrameLayout == null) {
            this.containerFrameLayout = new FrameLayout(_this);
        }
        this.virtualKeyboardLayout = new LinearLayout(_this);
        Activity activity = _activity;
        if (activity != null && this._bCreateView) {
            activity.getWindow().takeSurface(null);
            SurfaceView surfaceView = new SurfaceView(_this);
            this.MySurfaceView = surfaceView;
            surfaceView.setBackgroundColor(0);
            this.MySurfaceView.getHolder().addCallback((SurfaceHolder.Callback2) _this);
            this.containerFrameLayout.addView(this.MySurfaceView);
        }
        this.containerFrameLayout.addView(this.virtualKeyboardLayout);
        return this.containerFrameLayout;
    }

    public String getConnectionType() {
        boolean z16;
        boolean isAirplaneModeOn = isAirplaneModeOn(getApplicationContext());
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnectedOrConnecting()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            int type = NetworkMonitor.getType(activeNetworkInfo);
            if (type != 1) {
                if (type != 9) {
                    if (type != 6) {
                        if (type != 7) {
                            if (isAirplaneModeOn) {
                                return "AirplaneMode";
                            }
                            return "Cell";
                        }
                        if (isAirplaneModeOn) {
                            return "AirplaneMode";
                        }
                        return "Bluetooth";
                    }
                    if (isAirplaneModeOn) {
                        return "AirplaneMode";
                    }
                    return "WiMAX";
                }
                return "Ethernet";
            }
            return "WiFi";
        }
        if (isAirplaneModeOn) {
            return "AirplaneMode";
        }
        return "None";
    }

    @Override // com.epicgames.ue4.GameActivityBase
    public Context getContext() {
        return _context;
    }

    public int getCurrentDeviceRotationDegree() {
        int AndroidThunkJava_GetDeviceOrientation = AndroidThunkJava_GetDeviceOrientation();
        if (AndroidThunkJava_GetDeviceOrientation != 1) {
            if (AndroidThunkJava_GetDeviceOrientation != 2) {
                if (AndroidThunkJava_GetDeviceOrientation != 3) {
                    return 0;
                }
                return 270;
            }
            return 180;
        }
        return 90;
    }

    public int getDeviceDefaultOrientation() {
        Activity activity = _activity;
        if (activity == null) {
            if (getResources().getConfiguration().orientation != 2) {
                return 1;
            }
            return 2;
        }
        WindowManager windowManager = activity.getWindowManager();
        Configuration configuration = getResources().getConfiguration();
        int rotation = windowManager.getDefaultDisplay().getRotation();
        if (((rotation != 0 && rotation != 2) || configuration.orientation != 2) && ((rotation != 1 && rotation != 3) || configuration.orientation != 1)) {
            return 1;
        }
        return 2;
    }

    public String getExternalFilesDirAbsolutePath() {
        File externalFilesDir = getExternalFilesDir(null);
        if (externalFilesDir != null) {
            return externalFilesDir.getAbsolutePath() + "/";
        }
        UE4.log("GameActivity.getExternalFilesDirAbsolutePath", "getExternalFilesDir(null) return null");
        return null;
    }

    public String getExternalFilesDirPath() {
        File externalFilesDir = getExternalFilesDir(null);
        if (externalFilesDir != null) {
            return externalFilesDir.getPath();
        }
        UE4.log("GameActivity.getExternalFilesDirPath", "getExternalFilesDir(null) return null");
        return null;
    }

    public String getFilesDirAbsolutePath() {
        File filesDir = getFilesDir();
        if (filesDir != null) {
            return filesDir.getAbsolutePath() + "/";
        }
        UE4.log("GameActivity.getFilesDirAbsolutePath", "getFilesDir() return null");
        return null;
    }

    public String getFilesDirPath() {
        File filesDir = getFilesDir();
        if (filesDir != null) {
            return filesDir.getPath();
        }
        UE4.log("GameActivity.getFilesDirPath", "getFilesDir() return null");
        return null;
    }

    public boolean isFinishing() {
        Activity activity = _activity;
        if (activity != null) {
            return activity.isFinishing();
        }
        return false;
    }

    public boolean isFirstCallingOnCreate() {
        if (this._onCreateCallings == 1) {
            return true;
        }
        return false;
    }

    @Override // com.epicgames.ue4.GameActivityBase
    public boolean isShippingBuild() {
        return nativeIsShippingBuild();
    }

    public native void nativeConsoleCommand(String str);

    public native int nativeGetCPUFamily();

    public native void nativeGoogleClientConnectCompleted(boolean z16, String str);

    public native void nativeHandleSensorEvents(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4);

    public native void nativeInitHMDs();

    public native boolean nativeIsShippingBuild();

    public native void nativeOnActivityResult(GameActivity gameActivity, int i3, int i16, Intent intent);

    public native void nativeOnConfigurationChanged(boolean z16);

    public native void nativeOnInitialDownloadCompleted();

    public native void nativeOnInitialDownloadStarted();

    public native void nativeOnMemoryWarningChanged(GameActivity gameActivity, int i3);

    public native void nativeOnThermalStatusChangedListener(GameActivity gameActivity, int i3);

    public native void nativeResumeMainInit();

    public native void nativeSetAffinityInfo(boolean z16, int i3, int i16);

    public native void nativeSetAndroidStartupState(boolean z16);

    public native void nativeSetAndroidVersionInformation(String str, int i3, String str2, String str3, String str4, String str5);

    public native void nativeSetConfigRulesVariables(String[] strArr);

    public native void nativeSetGlobalActivity(boolean z16, boolean z17, String str, String str2, boolean z18, String str3);

    public native void nativeSetObbFilePaths(String str, String str2, String str3, String str4);

    public native void nativeSetObbInfo(String str, String str2, int i3, int i16, String str3);

    public native void nativeSetSafezoneInfo(boolean z16, float f16, float f17, float f18, float f19);

    public native void nativeSetSurfaceViewInfo(int i3, int i16);

    public native void nativeSetWindowInfo(boolean z16, int i3);

    public native boolean nativeSupportsNEON();

    public native void nativeVirtualKeyboardChanged(String str);

    public native void nativeVirtualKeyboardResult(boolean z16, String str);

    public native void nativeVirtualKeyboardSendKey(int i3);

    public native void nativeVirtualKeyboardSendSelection(int i3, int i16);

    public native void nativeVirtualKeyboardSendTextSelection(String str, int i3, int i16);

    public native void nativeVirtualKeyboardShown(int i3, int i16, int i17, int i18);

    public native void nativeVirtualKeyboardVisible(boolean z16);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.epicgames.ue4.GameActivityBase
    public void onActivityResult(int i3, int i16, Intent intent) {
        int i17;
        String str;
        if (i3 == 80001) {
            boolean z16 = false;
            if (i16 == -1) {
                i17 = intent.getIntExtra(DOWNLOAD_RETURN_NAME, 0);
                switch (i17) {
                    case 0:
                        str = "DownloadActivity Returned with Download No Return Code";
                        break;
                    case 1:
                        str = "DownloadActivity Returned with Download Files Present";
                        break;
                    case 2:
                        str = "DownloadActivity Returned with Download Completed OK";
                        break;
                    case 3:
                        str = "DownloadActivity Returned with Download User Quit";
                        break;
                    case 4:
                        str = "DownloadActivity Returned with Download Failed";
                        break;
                    case 5:
                        str = "DownloadActivity Returned with Download Invalid";
                        break;
                    case 6:
                        str = "DownloadActivity Returned with Download No Play Key";
                        break;
                    default:
                        str = "DownloadActivity Returned with Unknown message!";
                        break;
                }
                Log.debug(str);
            } else {
                Log.debug("Download activity cancelled by user.");
                i17 = 3;
            }
            nativeOnInitialDownloadCompleted();
            if (i17 == 1 || i17 == 2) {
                z16 = true;
            }
            this.HasAllFiles = z16;
            if (i17 == 0 || i17 == 3 || i17 == 4 || i17 == 5 || i17 == 6) {
                _activity.finish();
                return;
            }
        } else {
            super.onActivityResult(i3, i16, intent);
        }
        GCloudAppLifecycle.Instance.onActivityResult(i3, i16, intent);
        if (this.InitCompletedOK) {
            nativeOnActivityResult(this, i3, i16, intent);
        }
    }

    @Override // com.epicgames.ue4.GameActivityBase, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        boolean z16 = true;
        if (configuration.orientation != 1) {
            z16 = false;
        }
        nativeOnConfigurationChanged(z16);
    }

    @Override // com.epicgames.ue4.GameActivityBase
    public void onCreate(Bundle bundle, boolean z16) {
        this._bCreateView = z16;
        this.containerFrameLayout = null;
        onCreate(bundle);
    }

    @Override // com.epicgames.ue4.GameActivityBase
    public void onDestroy() {
        synchronized (this) {
            if (this.memoryHandler != null) {
                Log.debug("onDestroy: destroy memoryHandler");
                this.memoryHandler.removeCallbacks(this.memoryRunnable);
                this.memoryHandler = null;
            }
            if (this.memoryHandlerThread != null) {
                Log.debug("onDestroy: destroy memoryHandlerThread");
                this.memoryHandlerThread.quit();
                this.memoryHandlerThread = null;
            }
        }
        StoreHelper storeHelper = this.IapStoreHelper;
        if (storeHelper != null) {
            storeHelper.onDestroy();
        }
        GCloudAppLifecycle.Instance.onDestroy();
        super.onDestroy();
        Log.debug("==============> GameActive.onDestroy complete!");
    }

    @Override // com.epicgames.ue4.GameActivityBase
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        Bundle bundle;
        if ((i3 == 4 || i3 == 25 || i3 == 24) && this.ShouldHideUI && _activity != null && UE4.isImmersiveMode()) {
            Log.debug("=== Restoring Transparent Bars due to KeyCode ===");
            restoreTranslucentBarsDelayed();
        }
        if (i3 == 4 && (bundle = _extrasBundle) != null && bundle.containsKey(UE4.AVATAR_VIEW_TYPE_KEY)) {
            Log.debug("==============> GameActivity.onKeyDown  call leaveAvatarShow, " + _extrasBundle.getInt(UE4.AVATAR_VIEW_TYPE_KEY));
            UE4.leaveAvatarShow();
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // com.epicgames.ue4.GameActivityBase
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Activity activity = _activity;
        if (activity == null) {
            return;
        }
        activity.setIntent(intent);
        GCloudAppLifecycle.Instance.onNewIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.epicgames.ue4.GameActivityBase
    public void onPause() {
        Activity activity;
        UE4.profileBegin();
        synchronized (this) {
            if (this.memoryHandler != null) {
                Log.debug("onPause: stop memory reporter runnable");
                this.memoryHandler.removeCallbacks(this.memoryRunnable);
                this.memoryHandler = null;
            }
        }
        releaseSensors();
        if (this.bKeyboardShowing) {
            AndroidThunkJava_HideVirtualKeyboardInput();
        }
        if (this.CurrentDialogType != EAlertDialogType.None && (activity = _activity) != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.21
                @Override // java.lang.Runnable
                public void run() {
                    if (GameActivity._activity == null) {
                        return;
                    }
                    int i3 = AnonymousClass49.$SwitchMap$com$epicgames$ue4$GameActivity$EAlertDialogType[GameActivity.this.CurrentDialogType.ordinal()];
                    if (i3 != 1) {
                        if (i3 != 2) {
                            GameActivity.Log.debug("ERROR: Unknown EAlertDialogType!");
                            return;
                        } else {
                            GameActivity.this.consoleAlert.hide();
                            return;
                        }
                    }
                    GameActivity.this.virtualKeyboardAlert.hide();
                }
            });
        }
        GCloudAppLifecycle.Instance.onPause();
        try {
            Log.i("GVoiceJava", "call gvoice pause interface");
            GCloudVoiceEngine.getInstance().Pause();
        } catch (Exception unused) {
        }
        super.onPause();
        UE4.profileEnd();
        Log.debug("==============> GameActive.onPause complete!");
    }

    @Override // com.epicgames.ue4.GameActivityBase
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i3, strArr, iArr);
    }

    @Override // com.epicgames.ue4.GameActivityBase
    public void onRestart() {
        super.onRestart();
        GCloudAppLifecycle.Instance.onRestart();
    }

    @Override // com.epicgames.ue4.GameActivityBase
    public void onResume() {
        int i3;
        UE4.profileBegin();
        super.onResume();
        synchronized (this) {
            if (this.memoryHandler == null && this.memoryRunnable != null) {
                Log.debug("onResume: start memory reporter runnable");
                Handler handler = new Handler(this.memoryHandlerThread.getLooper());
                this.memoryHandler = handler;
                handler.postDelayed(this.memoryRunnable, 1000L);
            }
        }
        if (_activity != null && UE4.isImmersiveMode() && this.ShouldHideUI) {
            restoreTransparentBars();
            View decorView = _activity.getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.epicgames.ue4.GameActivity.18
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i16) {
                    GameActivity.Log.debug("=== Restoring Transparent Bars due to Visibility Change ===");
                    GameActivity.this.restoreTransparentBars();
                }
            });
            decorView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.epicgames.ue4.GameActivity.19
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean z16) {
                    GameActivity.Log.debug("=== Restoring Transparent Bars due to Focus Change ===");
                    GameActivity.this.restoreTransparentBars();
                }
            });
        }
        Activity activity = _activity;
        if (activity != null && this.UseDisplayCutout) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            i3 = attributes.layoutInDisplayCutoutMode;
            if (i3 != 1) {
                attributes.layoutInDisplayCutoutMode = 1;
                _activity.getWindow().setAttributes(attributes);
            }
        }
        AndroidThunkJava_KeepScreenOn(this.bKeepScreenOn);
        SetDisableScreenCaptureInternal(AndroidThunkJava_IsScreenCaptureDisabled());
        if (!this.bForceGameEndWithError && !this.bForceGameEndWithWarning) {
            onResumeBody();
            UE4.profileEnd();
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.epicgames.ue4.GameActivity.20
            @Override // java.lang.Runnable
            public void run() {
                if (GameActivity._activity == null || GameActivity.this.ForceGameDialog != null) {
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity._activity);
                builder.setCancelable(false);
                builder.setTitle(GameActivity.this.ForceExitCaption);
                builder.setMessage(GameActivity.this.ForceExitMessage);
                if (!GameActivity.this.ForceExitLink.equals("")) {
                    builder.setNeutralButton(GameActivity.this.ForceExitHelpButtonText, new DialogInterface.OnClickListener() { // from class: com.epicgames.ue4.GameActivity.20.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i16) {
                            dialogInterface.dismiss();
                            GameActivity gameActivity = GameActivity.this;
                            gameActivity.AndroidThunkJava_LaunchURL(gameActivity.ForceExitLink);
                            GameActivity.this.AndroidThunkJava_ForceQuit();
                        }
                    });
                }
                if (GameActivity.this.bForceGameEndWithWarning) {
                    builder.setNegativeButton(GameActivity.this.ForceExitContinueButtonText, new DialogInterface.OnClickListener() { // from class: com.epicgames.ue4.GameActivity.20.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i16) {
                            dialogInterface.dismiss();
                            GameActivity.this.ForceGameDialog = null;
                            GameActivity.this.bForceGameEndWithWarning = false;
                            GameActivity.this.onResumeBody();
                        }
                    });
                }
                if (!GameActivity.this.ForceExitUpdateButtonText.equals("")) {
                    builder.setPositiveButton(GameActivity.this.ForceExitUpdateButtonText, new DialogInterface.OnClickListener() { // from class: com.epicgames.ue4.GameActivity.20.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i16) {
                            dialogInterface.dismiss();
                            int i17 = GameActivity.ANDROID_BUILD_VERSION;
                            if (i17 >= 16 && i17 < 19) {
                                GameActivity.this.AndroidThunkJava_OpenIntentAction("android.settings.SETTINGS");
                            } else if (GameActivity.this.AndroidThunkJava_isIntentActionAvailable("android.settings.SYSTEM_UPDATE_SETTINGS")) {
                                GameActivity.this.AndroidThunkJava_OpenIntentAction("android.settings.SYSTEM_UPDATE_SETTINGS");
                            } else {
                                GameActivity.this.AndroidThunkJava_OpenIntentAction("android.settings.SETTINGS");
                            }
                            GameActivity.this.AndroidThunkJava_ForceQuit();
                        }
                    });
                } else {
                    builder.setPositiveButton(GameActivity.this.ForceExitQuitButtonText, new DialogInterface.OnClickListener() { // from class: com.epicgames.ue4.GameActivity.20.4
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i16) {
                            dialogInterface.dismiss();
                            GameActivity.this.AndroidThunkJava_ForceQuit();
                        }
                    });
                }
                GameActivity.this.ForceGameDialog = builder.create();
                GameActivity.this.ForceGameDialog.show();
            }
        };
        Activity activity2 = _activity;
        if (activity2 != null) {
            activity2.runOnUiThread(runnable);
        } else {
            _UIHandler.post(runnable);
        }
    }

    @Override // com.epicgames.ue4.GameActivityBase
    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        super.onSaveInstanceState(bundle, persistableBundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // android.hardware.SensorEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSensorChanged(SensorEvent sensorEvent) {
        boolean z16;
        boolean z17;
        this.sensorCbTimes++;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.sensorCbTimestamp > 1000) {
            this.sensorCbTimestamp = currentTimeMillis;
            Log.debug("onSensorChanged sensorCbTimes:" + this.sensorCbTimes);
        }
        if (this.bAllowIMU && this.accelerometer != null && this.magnetometer != null) {
            if (sensorEvent.sensor.getType() == 1) {
                System.arraycopy(sensorEvent.values, 0, current_accelerometer, 0, 3);
                if (!first_acceleration_sample) {
                    float[] fArr = filtered_gravity;
                    float[] fArr2 = last_gravity;
                    float f16 = fArr2[0] * 0.85f;
                    float[] fArr3 = current_accelerometer;
                    fArr[0] = f16 + (fArr3[0] * 0.14999998f);
                    fArr[1] = (fArr2[1] * 0.85f) + (fArr3[1] * 0.14999998f);
                    fArr[2] = (fArr2[2] * 0.85f) + (fArr3[2] * 0.14999998f);
                }
                first_acceleration_sample = false;
                last_gravity = filtered_gravity;
            } else if (sensorEvent.sensor.getType() == 2) {
                System.arraycopy(sensorEvent.values, 0, current_magnetometer, 0, 3);
            } else {
                if (sensorEvent.sensor.getType() == 4) {
                    System.arraycopy(sensorEvent.values, 0, current_gyroscope, 0, 3);
                    z16 = true;
                } else {
                    z16 = false;
                }
                z17 = z16;
                if (!z16) {
                    SensorManager.getRotationMatrix(this.rotationMatrix, null, current_accelerometer, current_magnetometer);
                    SensorManager.getOrientation(this.rotationMatrix, this.orientationAngles);
                    synchronized (this) {
                        float[] fArr4 = filtered_gravity;
                        current_gravity = fArr4;
                        float[] fArr5 = this.current_tilt;
                        float[] fArr6 = this.orientationAngles;
                        fArr5[0] = fArr6[1];
                        fArr5[1] = fArr6[2];
                        fArr5[2] = fArr6[0];
                        float[] fArr7 = current_acceleration;
                        float[] fArr8 = current_accelerometer;
                        fArr7[0] = fArr8[0] - fArr4[0];
                        fArr7[1] = fArr8[1] - fArr4[1];
                        fArr7[2] = fArr8[2] - fArr4[2];
                        if (z17) {
                            current_rotation_rate = current_gyroscope;
                        } else if (this.gyroscope == null) {
                            float[] fArr9 = current_rotation_rate;
                            float f17 = fArr5[0];
                            float[] fArr10 = last_tilt;
                            fArr9[0] = f17 - fArr10[0];
                            fArr9[1] = fArr5[1] - fArr10[1];
                            fArr9[2] = fArr5[2] - fArr10[2];
                        }
                        last_tilt = fArr5;
                    }
                    this.bSensorDataUpdated = true;
                    return;
                }
                return;
            }
            z16 = true;
            z17 = false;
            if (!z16) {
            }
        }
    }

    @Override // com.epicgames.ue4.GameActivityBase
    public void onStart() {
        super.onStart();
        if (!this.BuildConfiguration.equals("Shipping")) {
            Log.debug("Creating console command broadcast listener");
            ConsoleCmdReceiver consoleCmdReceiver = new ConsoleCmdReceiver(this);
            this.consoleCmdReceiver = consoleCmdReceiver;
            registerReceiver(consoleCmdReceiver, new IntentFilter("android.intent.action.RUN"));
        }
        GCloudAppLifecycle.Instance.onStart();
        Log.debug("==================================> Inside onStart function in GameActivity");
    }

    @Override // com.epicgames.ue4.GameActivityBase
    public void onStop() {
        ConsoleCmdReceiver consoleCmdReceiver = this.consoleCmdReceiver;
        if (consoleCmdReceiver != null) {
            unregisterReceiver(consoleCmdReceiver);
        }
        GCloudAppLifecycle.Instance.onStop();
        super.onStop();
        Log.debug("==============> GameActive.onStop complete!");
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i3) {
        if (i3 != 5) {
            if (i3 != 10) {
                if (i3 != 15) {
                    if (i3 != 20) {
                        if (i3 != 40) {
                            if (i3 != 60) {
                                if (i3 != 80) {
                                    Log.debug("==============> GameActive.onTrimMemory(" + i3 + ") called!");
                                    return;
                                }
                                Log.debug("==============> GameActive.onTrimMemory(TRIM_MEMORY_COMPLETE) called!");
                                return;
                            }
                            Log.debug("==============> GameActive.onTrimMemory(TRIM_MEMORY_MODERATE) called!");
                            return;
                        }
                        Log.debug("==============> GameActive.onTrimMemory(TRIM_MEMORY_BACKGROUND) called!");
                        return;
                    }
                    Log.debug("==============> GameActive.onTrimMemory(TRIM_MEMORY_UI_HIDDEN) called!");
                    return;
                }
                Log.debug("==============> GameActive.onTrimMemory(TRIM_MEMORY_RUNNING_CRITICAL) called!");
                return;
            }
            Log.debug("==============> GameActive.onTrimMemory(TRIM_MEMORY_RUNNING_LOW) called!");
            return;
        }
        Log.debug("==============> GameActive.onTrimMemory(TRIM_MEMORY_RUNNING_MODERATE) called!");
    }

    public void processLastVirtualKeyboardCommand() {
        int i3;
        int i16;
        PasswordTransformationMethod passwordTransformationMethod;
        UE4.logMessage("VK: process last command " + lastVirtualKeyboardCommand);
        synchronized (this) {
            if (this.newVirtualKeyboardInput == null) {
                Log.debug("processLastVirtualKeyboardCommand: newVirtualKeyboardInput is null");
            } else {
                int i17 = AnonymousClass49.$SwitchMap$com$epicgames$ue4$GameActivity$VirtualKeyboardCommand[lastVirtualKeyboardCommand.ordinal()];
                if (i17 != 1) {
                    if (i17 == 2 && (this.bKeyboardShowing || this.newVirtualKeyboardInput.getVisibility() != 8)) {
                        if (this.newVirtualKeyboardInput.hasFocus()) {
                            try {
                                this.newVirtualKeyboardInput.clearFocus();
                            } catch (Exception unused) {
                                Log.warn("Unable to clear focus from virtualKeyboardInput");
                            }
                        }
                        this.newVirtualKeyboardInput.setY(-1000.0f);
                        this.newVirtualKeyboardInput.setVisibility(8);
                        ((InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.newVirtualKeyboardInput.getWindowToken(), 0);
                        nativeVirtualKeyboardVisible(false);
                        this.bKeyboardShowing = false;
                    }
                } else {
                    this.newVirtualKeyboardInput.setVisibility(0);
                    this.newVirtualKeyboardInput.setY(-1000.0f);
                    this.newVirtualKeyboardInput.setText(this.virtualKeyboardInputContent);
                    int i18 = this.virtualKeyboardInputType | 524288;
                    this.newVirtualKeyboardInput.setInputType(i18);
                    this.newVirtualKeyboardInput.setRawInputType(i18);
                    if (ANDROID_BUILD_VERSION >= 11) {
                        i3 = 301989888;
                    } else {
                        i3 = 268435456;
                    }
                    if ((this.virtualKeyboardInputType & 131072) != 0) {
                        this.newVirtualKeyboardInput.setSingleLine(false);
                        this.newVirtualKeyboardInput.setMaxLines(5);
                        i16 = (i3 | 1073741824) & (-7);
                    } else {
                        this.newVirtualKeyboardInput.setSingleLine(true);
                        this.newVirtualKeyboardInput.setMaxLines(1);
                        i16 = (i3 & (-1073741825)) | 6;
                    }
                    this.newVirtualKeyboardInput.setImeOptions(i16);
                    VirtualKeyboardInput virtualKeyboardInput = this.newVirtualKeyboardInput;
                    if ((this.virtualKeyboardInputType & 128) == 0) {
                        passwordTransformationMethod = null;
                    } else {
                        passwordTransformationMethod = PasswordTransformationMethod.getInstance();
                    }
                    virtualKeyboardInput.setTransformationMethod(passwordTransformationMethod);
                    VirtualKeyboardInput virtualKeyboardInput2 = this.newVirtualKeyboardInput;
                    virtualKeyboardInput2.setSelection(virtualKeyboardInput2.getText().length());
                    if (this.newVirtualKeyboardInput.requestFocus()) {
                        ((InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(this.newVirtualKeyboardInput, 0);
                        nativeVirtualKeyboardVisible(true);
                        this.bKeyboardShowing = true;
                        CheckKeyboardDisplayed();
                    }
                }
            }
        }
        lastVirtualKeyboardCommand = VirtualKeyboardCommand.VK_CMD_NONE;
    }

    @Override // com.epicgames.ue4.GameActivityBase
    public void releaseSensors() {
        if (!this.bAllowIMU) {
            return;
        }
        if (this.accelerometer == null && this.magnetometer == null && this.gyroscope == null) {
            UE4.logMessage("GameActivity.releaseSensors: Ignored, since sensors are already released or no sensors are acquired.");
            return;
        }
        UE4.logMessage("GameActivity.releaseSensors: Unregistering sensor listeners");
        SensorManager sensorManager = this.sensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        this.accelerometer = null;
        this.magnetometer = null;
        this.gyroscope = null;
    }

    public void resetSensors() {
        SensorManager sensorManager;
        if (UE4.hasOption(5) && (sensorManager = this.sensorManager) != null) {
            sensorManager.unregisterListener(this);
        }
        this.sensorManager = (SensorManager) getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        this.accelerometer = null;
        this.magnetometer = null;
        this.gyroscope = null;
        UE4.logMessage("GameActivity.resetSensors called");
    }

    public void restoreTranslucentBarsDelayed() {
        if (_activity == null) {
            return;
        }
        restoreTransparentBars();
        this.mRestoreImmersiveModeHandler.postDelayed(this.restoreImmersiveModeRunnable, 500L);
    }

    public void restoreTransparentBars() {
        Activity activity = _activity;
        if (activity != null) {
            try {
                View decorView = activity.getWindow().getDecorView();
                Log.debug("=== Restoring Transparent Bars ===");
                decorView.setSystemUiVisibility(1798);
                decorView.setSystemUiVisibility(5894);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.epicgames.ue4.GameActivityBase
    public void setContext(Context context) {
        Activity activity;
        if (_context == context) {
            return;
        }
        onDetachContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        _activity = activity;
        _this = context;
        _context = context;
        GameActivityBase.clientActivity = activity;
        GameActivity gameActivity = _singleton;
        if (gameActivity != null) {
            gameActivity.attachBaseContext(context);
        }
    }

    public void setDownloadShimInterface(DownloadShimInterface downloadShimInterface) {
        this.mDownloadShimInterface = downloadShimInterface;
    }

    @Override // com.epicgames.ue4.GameActivityBase, android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
        if (this.bUseSurfaceView) {
            int i18 = this.DesiredHolderWidth;
            if (i18 > 0) {
                i16 = i18;
            }
            int i19 = this.DesiredHolderHeight;
            if (i19 > 0) {
                i17 = i19;
            }
            super.surfaceChanged(surfaceHolder, i3, i16, i17);
            surfaceHolder.setFixedSize(i16, i17);
            nativeSetSurfaceViewInfo(surfaceHolder.getSurfaceFrame().width(), surfaceHolder.getSurfaceFrame().height());
            return;
        }
        super.surfaceChanged(surfaceHolder, i3, i16, i17);
    }

    @Override // com.epicgames.ue4.GameActivityBase, android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        super.surfaceRedrawNeededAsync(surfaceHolder, runnable);
    }

    public void writeLoginId(String str, String str2) {
        if (!writeFile(str + "/login-identifier.txt", str2)) {
            Log.debug("failed to create login-identifier.txt");
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class VirtualKeyboardInput extends EditText {
        private EmojiExcludeFilter emojiExcludeFilter;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public class EmojiExcludeFilter implements InputFilter {
            EmojiExcludeFilter() {
            }

            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
                while (i3 < i16) {
                    int type = Character.getType(charSequence.charAt(i3));
                    if (type != 19 && type != 28) {
                        i3++;
                    } else {
                        return "";
                    }
                }
                return null;
            }
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        private class VirtualKeyboardInputConnection extends InputConnectionWrapper {
            VirtualKeyboardInput owner;

            public VirtualKeyboardInputConnection(InputConnection inputConnection, boolean z16, VirtualKeyboardInput virtualKeyboardInput) {
                super(inputConnection, z16);
                this.owner = virtualKeyboardInput;
            }

            private void replaceSubstring(String str) {
                StringBuffer stringBuffer = new StringBuffer(this.owner.getText().toString());
                int selectionStart = this.owner.getSelectionStart();
                int selectionEnd = this.owner.getSelectionEnd();
                int min = Math.min(selectionStart, selectionEnd);
                int max = Math.max(selectionStart, selectionEnd);
                if (min != max) {
                    stringBuffer.replace(min, max, str);
                } else if (str.length() > 0) {
                    stringBuffer.insert(min, str);
                } else if (min > 0) {
                    BreakIterator characterInstance = BreakIterator.getCharacterInstance();
                    characterInstance.setText(this.owner.getText().toString());
                    int preceding = characterInstance.preceding(min);
                    if (preceding == -1) {
                        preceding = 0;
                    }
                    min = preceding;
                    stringBuffer.replace(min, max, "");
                }
                if (str.length() == 0) {
                    min--;
                }
                this.owner.getText().clear();
                this.owner.append(stringBuffer.toString());
                this.owner.setSelection(min + 1);
            }

            @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
            public boolean deleteSurroundingText(int i3, int i16) {
                if (i3 == 1 && i16 == 0) {
                    if (sendKeyEvent(new KeyEvent(0, 67)) && sendKeyEvent(new KeyEvent(1, 67))) {
                        return true;
                    }
                    return false;
                }
                return super.deleteSurroundingText(i3, i16);
            }

            @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
            public boolean sendKeyEvent(KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0) {
                    if (keyEvent.getKeyCode() >= 7 && keyEvent.getKeyCode() <= 16) {
                        replaceSubstring(String.valueOf((char) ((keyEvent.getKeyCode() - 7) + 48)));
                        return true;
                    }
                    if (keyEvent.getKeyCode() >= 144 && keyEvent.getKeyCode() <= 153) {
                        replaceSubstring(String.valueOf((char) ((keyEvent.getKeyCode() - 144) + 48)));
                        return true;
                    }
                    if (keyEvent.getKeyCode() == 67) {
                        replaceSubstring("");
                        return true;
                    }
                    if (keyEvent.getKeyCode() == 66) {
                        if ((VirtualKeyboardInput.this.getInputType() & 131072) != 0) {
                            replaceSubstring("\n");
                            return true;
                        }
                        GameActivity.this.AndroidThunkJava_HideVirtualKeyboardInput();
                        GameActivity.this.nativeVirtualKeyboardSendKey(66);
                        return true;
                    }
                    return true;
                }
                return true;
            }
        }

        public VirtualKeyboardInput(Context context, AttributeSet attributeSet, int i3) {
            super(context, attributeSet, i3);
            init();
        }

        private void init() {
            if (this.emojiExcludeFilter == null) {
                this.emojiExcludeFilter = new EmojiExcludeFilter();
            }
        }

        @Override // android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            return new VirtualKeyboardInputConnection(super.onCreateInputConnection(editorInfo), true, this);
        }

        @Override // android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i3, KeyEvent keyEvent) {
            if (i3 == 4 && keyEvent.getAction() == 0) {
                GameActivity.this.AndroidThunkJava_HideVirtualKeyboardInput();
                GameActivity.this.nativeVirtualKeyboardSendKey(4);
            }
            return super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.widget.TextView
        protected void onSelectionChanged(int i3, int i16) {
            GameActivity.this.nativeVirtualKeyboardSendSelection(i3, i16);
        }

        @Override // android.widget.TextView
        public void setFilters(InputFilter[] inputFilterArr) {
            if (inputFilterArr.length != 0 && this.emojiExcludeFilter != null) {
                int length = inputFilterArr.length;
                boolean z16 = false;
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        if (inputFilterArr[i3] == this.emojiExcludeFilter) {
                            break;
                        } else {
                            i3++;
                        }
                    } else {
                        z16 = true;
                        break;
                    }
                }
                if (z16) {
                    inputFilterArr = (InputFilter[]) Arrays.copyOf(inputFilterArr, inputFilterArr.length + 1);
                    inputFilterArr[inputFilterArr.length - 1] = this.emojiExcludeFilter;
                }
            }
            super.setFilters(inputFilterArr);
        }

        public VirtualKeyboardInput(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            init();
        }

        public VirtualKeyboardInput(Context context) {
            super(context);
            init();
        }
    }

    @Override // com.epicgames.ue4.GameActivityBase
    public void onCreate(Bundle bundle, FrameLayout frameLayout) {
        this._bCreateView = false;
        this.containerFrameLayout = frameLayout;
        onCreate(bundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x07d4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x07d5  */
    @Override // com.epicgames.ue4.GameActivityBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        int i3;
        NullPointerException nullPointerException;
        String str;
        PackageManager.NameNotFoundException nameNotFoundException;
        String str2;
        Bundle bundle2;
        Bundle bundle3;
        boolean z16;
        FeatureInfo[] featureInfoArr;
        String featureInfo;
        int indexOf;
        String substring;
        int indexOf2;
        String substring2;
        int indexOf3;
        UE4.profileBegin();
        this._onCreateCallings++;
        this.consoleCmdReceiver = null;
        UE4.profileBegin("STEP1");
        NativeCalls.KeepAwake("Native", true);
        NativeCalls.AllowJavaBackButtonEvent(true);
        this.AssetManagerReference = getAssets();
        UE4.profileEnd();
        UE4.profileBegin("STEP2");
        super.onCreate(bundle);
        resetSensors();
        this.InternalFilesDir = getFilesDirAbsolutePath();
        this.ExternalFilesDir = getExternalFilesDirAbsolutePath();
        UE4.profileEnd();
        UE4.profileBegin("STEP3");
        if (_activity != null && Build.VERSION.SDK_INT >= 26) {
            _activity.getWindow().getDecorView().setImportantForAutofill(8);
        }
        _extrasBundle = null;
        Activity activity = _activity;
        if (activity != null) {
            _extrasBundle = activity.getIntent().getExtras();
        }
        Bundle bundle4 = _extrasBundle;
        int i16 = 0;
        if (bundle4 != null) {
            this.ShouldHideUI = bundle4.getString("ShouldHideUI") != null;
            this.UseDisplayCutout = _extrasBundle.getString("UseDisplayCutout") != null;
            if (_extrasBundle.getString("UseSplashScreen") != null) {
                this.SplashScreenLaunch = true;
                try {
                    ReportDialog reportDialog = new ReportDialog(this, getResources().getIdentifier("UE4SplashTheme", "style", getPackageName()));
                    this.mSplashDialog = reportDialog;
                    reportDialog.setCancelable(false);
                    this.mSplashDialog.getWindow().setFlags(8, 8);
                    if (this.ShouldHideUI) {
                        this.mSplashDialog.getWindow().getDecorView().setSystemUiVisibility(3846);
                    }
                    this.mSplashDialog.show();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                try {
                    this.noActionAnimID = getResources().getIdentifier("noaction", "anim", getPackageName());
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
            }
            try {
                this.noActionAnimID = getResources().getIdentifier("noaction", "anim", getPackageName());
            } catch (Exception e18) {
                e18.printStackTrace();
            }
            if (this.UseDisplayCutout) {
                WindowManager.LayoutParams attributes = _activity.getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                _activity.getWindow().setAttributes(attributes);
            }
        }
        UE4.profileEnd();
        UE4.profileBegin("STEP4");
        try {
            i3 = InstalledAppListMonitor.getPackageInfo(getPackageManager(), getPackageName(), 0).applicationInfo.targetSdkVersion;
        } catch (PackageManager.NameNotFoundException e19) {
            Log.debug(e19.getMessage());
            i3 = 0;
        }
        boolean nativeIsShippingBuild = nativeIsShippingBuild();
        if (ANDROID_BUILD_VERSION >= 23 && i3 >= 23) {
            Log.debug("Target SDK is " + i3 + ".  This may cause issues if permissions are denied by the user.");
            if (!nativeIsShippingBuild && !PermissionHelper.checkPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE)) {
                Log.debug("android.permission.WRITE_EXTERNAL_STORAGE was not granted; this may cause issues with file access.");
            }
        }
        Logger.RegisterCallback(this);
        UE4.profileEnd();
        UE4.profileBegin("STEP5");
        if (nativeIsShippingBuild && UE4.hasOption(0)) {
            Logger.SuppressLogs();
        }
        if (this.memoryHandlerThread == null) {
            try {
                this.MemAdvisor = new MemoryAdvisor(this);
            } catch (NullPointerException e26) {
                Log.warn("Failed to create MemoryAdvisor NullPointer: " + e26.getMessage());
            } catch (NumberFormatException e27) {
                Log.warn("Failed to create MemoryAdvisor NumberFormat: " + e27.getMessage());
            } catch (Exception e28) {
                Log.warn("Failed to create MemoryAdvisor Exception: " + e28.getMessage());
            }
            this.LastMemoryInfoPollTime = System.currentTimeMillis();
            UE4.profileEnd();
            UE4.profileBegin("STEP6");
            this.memoryRunnable = new Runnable() { // from class: com.epicgames.ue4.GameActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    if (GameActivity.this.MemAdvisor == null) {
                        GameActivity.Log.warn("memoryRunnable: MemAdvisor is null,do nothing");
                        return;
                    }
                    JSONObject e29 = GameActivity.this.MemAdvisor.e();
                    MemoryAdvisor.MemoryState g16 = MemoryAdvisor.g(e29);
                    int i17 = 0;
                    if (g16 != GameActivity.this.MemState) {
                        int i18 = AnonymousClass49.$SwitchMap$com$google$android$apps$internal$games$memoryadvice$MemoryAdvisor$MemoryState[g16.ordinal()];
                        if (i18 != 1) {
                            if (i18 != 2) {
                                if (i18 != 3) {
                                    if (i18 == 4) {
                                        GameActivity.Log.warn("Critical memory limit. Estimated available memory is " + MemoryAdvisor.d(e29) + " bytes");
                                        GameActivity.this.nativeOnMemoryWarningChanged(GameActivity._singleton, 2);
                                    }
                                } else {
                                    GameActivity.Log.warn("Approaching memory limit. Estimated available memory is " + MemoryAdvisor.d(e29) + " bytes");
                                    GameActivity.this.nativeOnMemoryWarningChanged(GameActivity._singleton, 1);
                                }
                            } else {
                                GameActivity.this.nativeOnMemoryWarningChanged(GameActivity._singleton, 0);
                            }
                        } else {
                            GameActivity.Log.warn("Cannot determine memory state");
                            GameActivity.this.nativeOnMemoryWarningChanged(GameActivity._singleton, -1);
                        }
                        GameActivity.this.MemState = g16;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - GameActivity.this.LastMemoryInfoPollTime >= 10000) {
                        Debug.MemoryInfo[] processMemoryInfo = SystemMethodProxy.getProcessMemoryInfo((ActivityManager) GameActivity._singleton.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY), new int[]{Process.myPid()});
                        if (processMemoryInfo.length > 0) {
                            Debug.MemoryInfo memoryInfo = processMemoryInfo[0];
                            int i19 = memoryInfo.dalvikPss + memoryInfo.nativePss + memoryInfo.otherPss;
                            Map<String, String> memoryStats = memoryInfo.getMemoryStats();
                            if (memoryStats.containsKey("summary.total-pss")) {
                                i17 = Integer.parseInt(memoryStats.get("summary.total-pss"));
                            } else {
                                i17 = i19;
                            }
                        }
                        GameActivity.Log.debug("Used memory: " + i17 + " (" + GameActivity.this.FindLineFromStatus("VmRSS:") + ")");
                        GameActivity.this.LastMemoryInfoPollTime = currentTimeMillis;
                    }
                    synchronized (GameActivity._singleton) {
                        if (i17 > 0) {
                            GameActivity._singleton.UsedMemory = i17;
                        }
                        if (GameActivity._singleton.memoryHandler != null) {
                            GameActivity._singleton.memoryHandler.postDelayed(this, 100L);
                        }
                    }
                }
            };
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("MemoryUsageThread", 19);
            this.memoryHandlerThread = baseHandlerThread;
            baseHandlerThread.start();
            Handler handler = new Handler(this.memoryHandlerThread.getLooper());
            this.memoryHandler = handler;
            handler.postDelayed(this.memoryRunnable, 1L);
        }
        if (_activity != null && this._bCreateView) {
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
            marginLayoutParams.setMargins(0, 0, 0, 0);
            LinearLayout linearLayout = new LinearLayout(_activity);
            this.activityLayout = linearLayout;
            _activity.setContentView(linearLayout, marginLayoutParams);
        } else {
            this.activityLayout = null;
        }
        UE4.profileEnd();
        UE4.profileBegin("STEP7");
        Activity activity2 = _activity;
        if (activity2 != null) {
            activity2.setVolumeControlStream(3);
        }
        if (ANDROID_BUILD_VERSION >= 24) {
            FeatureInfo[] systemAvailableFeatures = getPackageManager().getSystemAvailableFeatures();
            int length = systemAvailableFeatures.length;
            int i17 = 0;
            while (i17 < length) {
                FeatureInfo featureInfo2 = systemAvailableFeatures[i17];
                String str3 = featureInfo2.name;
                if (str3 != null) {
                    if (str3.equals("android.hardware.vulkan.level")) {
                        String featureInfo3 = featureInfo2.toString();
                        int indexOf4 = featureInfo3.indexOf("v=");
                        if (indexOf4 >= 0 && (indexOf3 = (substring2 = featureInfo3.substring(indexOf4 + 2)).indexOf(" ")) >= 0) {
                            this.VulkanLevel = Integer.parseInt(substring2.substring(i16, indexOf3));
                            Log.debug("Vulkan level: " + this.VulkanLevel);
                        }
                    } else if (featureInfo2.name.equals("android.hardware.vulkan.version") && (indexOf = (featureInfo = featureInfo2.toString()).indexOf("v=")) >= 0 && (indexOf2 = (substring = featureInfo.substring(indexOf + 2)).indexOf(" ")) >= 0) {
                        int parseInt = Integer.parseInt(substring.substring(i16, indexOf2));
                        this.VulkanVersion = parseInt;
                        int i18 = (parseInt >> 22) & 1023;
                        int i19 = (parseInt >> 12) & 1023;
                        int i26 = parseInt & 4095;
                        this.VulkanVersionString = i18 + "." + i19 + "." + i26;
                        Logger logger = Log;
                        StringBuilder sb5 = new StringBuilder();
                        featureInfoArr = systemAvailableFeatures;
                        sb5.append("Vulkan version: ");
                        sb5.append(i18);
                        sb5.append(".");
                        sb5.append(i19);
                        sb5.append(".");
                        sb5.append(i26);
                        logger.debug(sb5.toString());
                        i17++;
                        systemAvailableFeatures = featureInfoArr;
                        i16 = 0;
                    }
                }
                featureInfoArr = systemAvailableFeatures;
                i17++;
                systemAvailableFeatures = featureInfoArr;
                i16 = 0;
            }
        }
        if (getDeviceDefaultOrientation() == 2) {
            if (getPackageManager().hasSystemFeature("com.google.android.tv")) {
                Log.debug("Detected Google TV, will default to landscape");
            } else {
                String str4 = Build.MANUFACTURER;
                if (str4.equals("NVIDIA")) {
                    if (DeviceInfoMonitor.getModel().equals("SHIELD")) {
                        Log.debug("Detected NVidia Shield, will default to landscape");
                    }
                    z16 = false;
                } else if (str4.equals("OUYA")) {
                    if (DeviceInfoMonitor.getModel().toLowerCase().startsWith("ouya_")) {
                        Log.debug("Detected Ouya console (" + DeviceInfoMonitor.getModel() + "), will default to landscape");
                    }
                    z16 = false;
                } else {
                    if (str4.equals("Amazon") && DeviceInfoMonitor.getModel().startsWith("AFT")) {
                        Log.debug("Detected Kindle Fire TV (" + DeviceInfoMonitor.getModel() + "), will default to landscape");
                    }
                    z16 = false;
                }
                if (z16) {
                    Log.debug("Setting screen orientation to landscape because we have detected landscape device");
                    _activity.setRequestedOrientation(0);
                }
            }
            z16 = true;
            if (z16) {
            }
        }
        UE4.profileEnd();
        UE4.profileBegin("STEP8");
        appPackageName = getPackageName();
        String packageName = getPackageName();
        String substring3 = packageName.substring(packageName.lastIndexOf(46) + 1);
        try {
            ApplicationInfo applicationInfo = getPackageManager().getApplicationInfo(getPackageName(), 128);
            Bundle bundle5 = applicationInfo.metaData;
            _bundle = bundle5;
            if ((applicationInfo.flags & 2) == 0) {
                this.IsForDistribution = true;
            }
            if (bundle5.containsKey("com.epicgames.ue4.GameActivity.DepthBufferPreference")) {
                this.DepthBufferPreference = bundle5.getInt("com.epicgames.ue4.GameActivity.DepthBufferPreference");
                Log.debug("Found DepthBufferPreference = " + this.DepthBufferPreference);
            } else {
                this.DepthBufferPreference = 0;
                Log.debug("Did not find DepthBufferPreference, using default.");
            }
            if (bundle5.containsKey("com.epicgames.ue4.GameActivity.bPackageDataInsideApk")) {
                PackageDataInsideApkValue = bundle5.getBoolean("com.epicgames.ue4.GameActivity.bPackageDataInsideApk") ? 1 : 0;
                Log.debug("Found bPackageDataInsideApk = " + PackageDataInsideApkValue);
            } else {
                PackageDataInsideApkValue = 0;
                Log.debug("Did not find bPackageDataInsideApk, using default.");
            }
            if (bundle5.containsKey("com.epicgames.ue4.GameActivity.ProjectName")) {
                substring3 = bundle5.getString("com.epicgames.ue4.GameActivity.ProjectName");
                Log.debug("Found ProjectName = " + substring3);
            } else {
                Log.debug("Did not find ProjectName, using package name = " + substring3);
            }
            if (bundle5.containsKey("com.epicgames.ue4.GameActivity.AppType")) {
                str = bundle5.getString("com.epicgames.ue4.GameActivity.AppType");
                try {
                    Log.debug("Found AppType = " + str);
                } catch (PackageManager.NameNotFoundException e29) {
                    nameNotFoundException = e29;
                    Log.debug("Failed to load meta-data: NameNotFound: " + nameNotFoundException.getMessage());
                    String str5 = str;
                    str2 = substring3;
                    ParseCommandline(str2, this.UseExternalFilesDir);
                    UE4.profileEnd();
                    UE4.profileBegin("STEP9");
                    if (processSystemInfo(str2, appPackageName)) {
                    }
                } catch (NullPointerException e36) {
                    nullPointerException = e36;
                    Log.debug("Failed to load meta-data: NullPointer: " + nullPointerException.getMessage());
                    String str52 = str;
                    str2 = substring3;
                    ParseCommandline(str2, this.UseExternalFilesDir);
                    UE4.profileEnd();
                    UE4.profileBegin("STEP9");
                    if (processSystemInfo(str2, appPackageName)) {
                    }
                }
            } else {
                Log.debug("Did not find AppType, using default application type");
                str = "";
            }
            if (bundle5.containsKey("com.epicgames.ue4.GameActivity.bHasOBBFiles")) {
                HasOBBFiles = bundle5.getBoolean("com.epicgames.ue4.GameActivity.bHasOBBFiles") ? 1 : 0;
                Log.debug("Found bHasOBBFiles = " + HasOBBFiles);
            } else {
                HasOBBFiles = 0;
                Log.debug("Did not find bHasOBBFiles, using default.");
            }
            if (bundle5.containsKey("com.epicgames.ue4.GameActivity.bVerifyOBBOnStartUp")) {
                this.VerifyOBBOnStartUp = bundle5.getBoolean("com.epicgames.ue4.GameActivity.bVerifyOBBOnStartUp");
                Log.debug("Found bVerifyOBBOnStartUp = " + this.VerifyOBBOnStartUp);
            } else {
                this.VerifyOBBOnStartUp = false;
                Log.debug("Did not find bVerifyOBBOnStartUp, using default.");
            }
            if (bundle5.containsKey("com.epicgames.ue4.GameActivity.bShouldHideUI")) {
                this.ShouldHideUI = bundle5.getBoolean("com.epicgames.ue4.GameActivity.bShouldHideUI");
                Log.debug("UI hiding set to " + this.ShouldHideUI);
            } else {
                this.ShouldHideUI = true;
                Log.debug("UI hiding not found. Leaving as " + this.ShouldHideUI);
            }
            if (!this.SplashScreenLaunch && Build.VERSION.SDK_INT >= 28) {
                if (bundle5.containsKey("com.epicgames.ue4.GameActivity.bUseDisplayCutout")) {
                    this.UseDisplayCutout = bundle5.getBoolean("com.epicgames.ue4.GameActivity.bUseDisplayCutout");
                    Log.debug("Display cutout set to " + this.UseDisplayCutout);
                } else {
                    Log.debug("Display cutout not found. Leaving as " + this.UseDisplayCutout);
                }
            }
            if (bundle5.containsKey("com.epicgames.ue4.GameActivity.BuildConfiguration")) {
                this.BuildConfiguration = bundle5.getString("com.epicgames.ue4.GameActivity.BuildConfiguration");
                Log.debug("BuildConfiguration set to " + this.BuildConfiguration);
            } else {
                Log.debug("BuildConfiguration not found");
            }
            if (bundle5.containsKey("com.epicgames.ue4.GameActivity.bUseExternalFilesDir")) {
                this.UseExternalFilesDir = bundle5.getBoolean("com.epicgames.ue4.GameActivity.bUseExternalFilesDir");
                Log.debug("UseExternalFilesDir set to " + this.UseExternalFilesDir);
            } else {
                Log.debug("bUseExternalFilesDir not found. Leaving as " + this.UseExternalFilesDir);
            }
            if (bundle5.containsKey("com.epicgames.ue4.GameActivity.bPublicLogFiles")) {
                this.PublicLogFiles = bundle5.getBoolean("com.epicgames.ue4.GameActivity.bPublicLogFiles");
                Log.debug("PublicLogFiles set to " + this.PublicLogFiles);
            } else {
                Log.debug("PublicLogFiles not found. Leaving as " + this.PublicLogFiles);
            }
            if (bundle5.containsKey("com.epicgames.ue4.GameActivity.bAllowIMU")) {
                this.bAllowIMU = bundle5.getBoolean("com.epicgames.ue4.GameActivity.bAllowIMU");
                Log.debug("AllowIMU set to " + this.bAllowIMU);
            }
            if (bundle5.containsKey("com.epicgames.ue4.GameActivity.bSupportsVulkan")) {
                this.bSupportsVulkan = bundle5.getBoolean("com.epicgames.ue4.GameActivity.bSupportsVulkan");
                Log.debug("SupportsVulkan set to " + this.bSupportsVulkan);
            }
            if (bundle5.containsKey("com.epicgames.ue4.GameActivity.EngineBranch")) {
                this.EngineBranch = bundle5.getString("com.epicgames.ue4.GameActivity.EngineBranch");
            }
            if (bundle5.containsKey("com.epicgames.ue4.GameActivity.ProjectVersion")) {
                this.ProjectVersion = bundle5.getString("com.epicgames.ue4.GameActivity.ProjectVersion");
            }
        } catch (PackageManager.NameNotFoundException e37) {
            nameNotFoundException = e37;
            str = "";
        } catch (NullPointerException e38) {
            nullPointerException = e38;
            str = "";
        }
        String str522 = str;
        str2 = substring3;
        ParseCommandline(str2, this.UseExternalFilesDir);
        UE4.profileEnd();
        UE4.profileBegin("STEP9");
        if (processSystemInfo(str2, appPackageName)) {
            UE4.profileEnd();
            UE4.profileBegin("STEP10");
            String packageResourcePath = getPackageResourcePath();
            Log.debug("APK path: " + packageResourcePath);
            Logger logger2 = Log;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("OBB in APK: ");
            sb6.append(PackageDataInsideApkValue == 1);
            logger2.debug(sb6.toString());
            nativeSetGlobalActivity(this.UseExternalFilesDir, this.PublicLogFiles, getFilesDirPath(), getExternalFilesDirPath(), PackageDataInsideApkValue == 1, packageResourcePath);
            if (UE4.isDeviceOrientationLocked()) {
                Log.debug("onCreate: isDeviceOrientationLocked");
                nativeSetWindowInfo(UE4.isDeviceOrientationLockedPortrait(), this.DepthBufferPreference);
            } else {
                nativeSetWindowInfo(getResources().getConfiguration().orientation == 1, this.DepthBufferPreference);
            }
            String locale = Locale.getDefault().toString();
            boolean isDebuggerConnected = Debug.isDebuggerConnected();
            nativeSetAndroidStartupState(isDebuggerConnected);
            Logger logger3 = Log;
            StringBuilder sb7 = new StringBuilder();
            sb7.append("Android version is ");
            String str6 = Build.VERSION.RELEASE;
            sb7.append(str6);
            logger3.debug(sb7.toString());
            Logger logger4 = Log;
            StringBuilder sb8 = new StringBuilder();
            sb8.append("Android manufacturer is ");
            String str7 = Build.MANUFACTURER;
            sb8.append(str7);
            logger4.debug(sb8.toString());
            Log.debug("Android model is " + DeviceInfoMonitor.getModel());
            Logger logger5 = Log;
            StringBuilder sb9 = new StringBuilder();
            sb9.append("Android build number is ");
            String str8 = Build.DISPLAY;
            sb9.append(str8);
            logger5.debug(sb9.toString());
            Log.debug("OS language is set to " + locale);
            Log.debug("Debugger attached is " + isDebuggerConnected);
            nativeSetAndroidVersionInformation(str6, i3, str7, DeviceInfoMonitor.getModel(), str8, locale);
            try {
                this.VersionCode = InstalledAppListMonitor.getPackageInfo(getPackageManager(), getPackageName(), 0).versionCode;
                nativeSetObbInfo(str2, getApplicationContext().getPackageName(), this.VersionCode, 0, str522);
            } catch (Exception e39) {
                Log.debug("==================================> PackageInfo failure getting .obb info: " + e39.getMessage());
            }
            UE4.profileEnd();
            UE4.profileBegin("STEP11");
            Activity activity3 = _activity;
            if (activity3 != null) {
                activity3.setVolumeControlStream(3);
            }
            EditText editText = new EditText(_this);
            this.consoleInputBox = editText;
            editText.setInputType(524289);
            this.consoleHistoryList = new ArrayList<>();
            this.consoleHistoryIndex = 0;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(_this);
            this.consoleDistance = viewConfiguration.getScaledPagingTouchSlop() * getResources().getDisplayMetrics().density;
            this.consoleVelocity = viewConfiguration.getScaledMinimumFlingVelocity() / 1000.0f;
            this.consoleInputBox.setOnTouchListener(new View.OnTouchListener() { // from class: com.epicgames.ue4.GameActivity.3
                private long downTime;
                private float downX;

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    if (action != 0) {
                        if (action != 1) {
                            return false;
                        }
                        long currentTimeMillis = System.currentTimeMillis() - this.downTime;
                        float x16 = motionEvent.getX() - this.downX;
                        float abs = Math.abs(x16);
                        GameActivity gameActivity = GameActivity.this;
                        if (abs <= gameActivity.consoleDistance || abs <= ((float) currentTimeMillis) * gameActivity.consoleVelocity) {
                            return false;
                        }
                        if (x16 < 0.0f) {
                            swipeLeft();
                        } else {
                            swipeRight();
                        }
                        return true;
                    }
                    this.downTime = System.currentTimeMillis();
                    this.downX = motionEvent.getX();
                    GameActivity.this.consoleInputBox.requestFocus();
                    return true;
                }

                public void swipeLeft() {
                    if (!GameActivity.this.consoleHistoryList.isEmpty()) {
                        GameActivity gameActivity = GameActivity.this;
                        if (gameActivity.consoleHistoryIndex + 1 < gameActivity.consoleHistoryList.size()) {
                            GameActivity gameActivity2 = GameActivity.this;
                            EditText editText2 = gameActivity2.consoleInputBox;
                            ArrayList<String> arrayList = gameActivity2.consoleHistoryList;
                            int i27 = gameActivity2.consoleHistoryIndex + 1;
                            gameActivity2.consoleHistoryIndex = i27;
                            editText2.setText(arrayList.get(i27));
                        }
                    }
                }

                public void swipeRight() {
                    GameActivity gameActivity;
                    int i27;
                    if (!GameActivity.this.consoleHistoryList.isEmpty() && (i27 = (gameActivity = GameActivity.this).consoleHistoryIndex) > 0) {
                        EditText editText2 = gameActivity.consoleInputBox;
                        ArrayList<String> arrayList = gameActivity.consoleHistoryList;
                        int i28 = i27 - 1;
                        gameActivity.consoleHistoryIndex = i28;
                        editText2.setText(arrayList.get(i28));
                    }
                }
            });
            this.consoleSpinner = new Spinner(_this);
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.simple_spinner_item, CONSOLE_SPINNER_ITEMS);
            arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
            this.consoleSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
            this.consoleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.epicgames.ue4.GameActivity.4
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view, int i27, long j3) {
                    if (i27 > 0) {
                        GameActivity.this.consoleInputBox.setText(adapterView.getItemAtPosition(i27).toString());
                    }
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                    GameActivity.this.consoleInputBox.setText("");
                    GameActivity.this.consoleSpinner.setSelection(0);
                }
            });
            LinearLayout linearLayout2 = new LinearLayout(_this);
            this.consoleAlertLayout = linearLayout2;
            linearLayout2.setOrientation(1);
            this.consoleAlertLayout.addView(this.consoleSpinner);
            this.consoleAlertLayout.addView(this.consoleInputBox);
            UE4.profileEnd();
            UE4.profileBegin("STEP12");
            AlertDialog.Builder builder = new AlertDialog.Builder(_this);
            builder.setTitle("Console Window - Enter Command").setMessage("").setView(this.consoleAlertLayout).setPositiveButton("Ok", new DialogInterface.OnClickListener() { // from class: com.epicgames.ue4.GameActivity.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i27) {
                    String trim = GameActivity.this.consoleInputBox.getText().toString().trim();
                    int indexOf5 = GameActivity.this.consoleHistoryList.indexOf(trim);
                    if (indexOf5 >= 0) {
                        GameActivity.this.consoleHistoryList.remove(indexOf5);
                    }
                    GameActivity.this.consoleHistoryList.add(trim);
                    GameActivity.this.nativeConsoleCommand(trim);
                    GameActivity.this.consoleInputBox.setText(" ");
                    GameActivity.this.consoleSpinner.setSelection(0);
                    dialogInterface.dismiss();
                    GameActivity.this.CurrentDialogType = EAlertDialogType.None;
                }
            }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: com.epicgames.ue4.GameActivity.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i27) {
                    GameActivity.this.consoleInputBox.setText(" ");
                    GameActivity.this.consoleSpinner.setSelection(0);
                    dialogInterface.dismiss();
                    GameActivity.this.CurrentDialogType = EAlertDialogType.None;
                }
            });
            this.consoleAlert = builder.create();
            EditText editText2 = new EditText(_this);
            this.virtualKeyboardInputBox = editText2;
            editText2.addTextChangedListener(new TextWatcher() { // from class: com.epicgames.ue4.GameActivity.7
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    GameActivity.this.nativeVirtualKeyboardChanged(GameActivity.this.virtualKeyboardInputBox.getText().toString());
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i27, int i28, int i29) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i27, int i28, int i29) {
                }
            });
            AlertDialog.Builder builder2 = new AlertDialog.Builder(_this);
            builder2.setTitle("").setView(this.virtualKeyboardInputBox).setPositiveButton("Ok", new DialogInterface.OnClickListener() { // from class: com.epicgames.ue4.GameActivity.9
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i27) {
                    GameActivity.this.nativeVirtualKeyboardResult(true, GameActivity.this.virtualKeyboardInputBox.getText().toString());
                    GameActivity.this.virtualKeyboardInputBox.setText(" ");
                    dialogInterface.dismiss();
                    GameActivity.this.CurrentDialogType = EAlertDialogType.None;
                }
            }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: com.epicgames.ue4.GameActivity.8
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i27) {
                    GameActivity gameActivity = GameActivity.this;
                    gameActivity.nativeVirtualKeyboardChanged(gameActivity.virtualKeyboardPreviousContents);
                    GameActivity.this.nativeVirtualKeyboardResult(false, " ");
                    GameActivity.this.virtualKeyboardInputBox.setText(" ");
                    dialogInterface.dismiss();
                    GameActivity.this.CurrentDialogType = EAlertDialogType.None;
                }
            });
            this.virtualKeyboardAlert = builder2.create();
            UE4.profileEnd();
            UE4.profileBegin("STEP13");
            GooglePlayLicensing googlePlayLicensing = new GooglePlayLicensing();
            GooglePlayLicensing.GoogleLicensing = googlePlayLicensing;
            googlePlayLicensing.Init(this, Log);
            if (PackageDataInsideApkValue == 1 || HasOBBFiles == 0) {
                this.HasAllFiles = true;
            }
            Activity activity4 = _activity;
            if (activity4 != null && !this.HasAllFiles && !this.VerifyOBBOnStartUp) {
                DownloadShimInterface downloadShimInterface = this.mDownloadShimInterface;
                if (downloadShimInterface != null) {
                    this.HasAllFiles = downloadShimInterface.expansionFilesDelivered(activity4, this.VersionCode);
                } else {
                    this.HasAllFiles = expansionFilesDelivered(activity4, this.VersionCode);
                }
            }
            UE4.profileEnd();
            UE4.profileBegin("STEP14");
            createContentView();
            Activity activity5 = _activity;
            if (activity5 != null && this._bCreateView) {
                activity5.setContentView(this.containerFrameLayout);
            }
            Activity activity6 = _activity;
            if (activity6 == null) {
                this.mainView = null;
                this.mainDecorView = null;
                this.mainDecorViewRect = null;
            }
            if (activity6 != null) {
                View findViewById = activity6.findViewById(R.id.content);
                this.mainView = findViewById;
                findViewById.setFocusable(true);
                this.mainView.setFocusableInTouchMode(true);
                this.mainDecorView = _activity.getWindow().getDecorView();
                this.mainDecorViewRect = new Rect();
                this.mainDecorView.findViewById(R.id.content).getRootView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.epicgames.ue4.GameActivity.10
                    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
                    
                        r9 = r10.getDisplayCutout();
                     */
                    @Override // android.view.View.OnApplyWindowInsetsListener
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        DisplayCutout displayCutout;
                        float f16;
                        float f17;
                        int safeInsetLeft;
                        int safeInsetTop;
                        int safeInsetRight;
                        int safeInsetBottom;
                        boolean z17;
                        if (GameActivity._activity != null && GameActivity.this.mainDecorView != null && Build.VERSION.SDK_INT >= 28 && displayCutout != null) {
                            new Rect();
                            GameActivity.this.mainDecorView.getDrawingRect(GameActivity.this.mainDecorViewRect);
                            Display defaultDisplay = GameActivity._activity.getWindowManager().getDefaultDisplay();
                            Point point = new Point();
                            defaultDisplay.getRealSize(point);
                            int i27 = point.x;
                            if (i27 != 0.0f) {
                                f16 = i27;
                            } else {
                                f16 = 1.0f;
                            }
                            float f18 = 1.0f / f16;
                            int i28 = point.y;
                            if (i28 != 0.0f) {
                                f17 = i28;
                            } else {
                                f17 = 1.0f;
                            }
                            float f19 = 1.0f / f17;
                            RectF rectF = GameActivity.this.safezoneF;
                            Rect rect = GameActivity.this.safezone;
                            safeInsetLeft = displayCutout.getSafeInsetLeft();
                            rect.left = safeInsetLeft;
                            rectF.left = safeInsetLeft * f18;
                            RectF rectF2 = GameActivity.this.safezoneF;
                            Rect rect2 = GameActivity.this.safezone;
                            safeInsetTop = displayCutout.getSafeInsetTop();
                            rect2.top = safeInsetTop;
                            rectF2.top = safeInsetTop * f19;
                            RectF rectF3 = GameActivity.this.safezoneF;
                            Rect rect3 = GameActivity.this.safezone;
                            safeInsetRight = displayCutout.getSafeInsetRight();
                            rect3.right = safeInsetRight;
                            rectF3.right = safeInsetRight * f18;
                            RectF rectF4 = GameActivity.this.safezoneF;
                            Rect rect4 = GameActivity.this.safezone;
                            safeInsetBottom = displayCutout.getSafeInsetBottom();
                            rect4.bottom = safeInsetBottom;
                            rectF4.bottom = safeInsetBottom * f19;
                            GameActivity gameActivity = GameActivity.this;
                            if (point.y > point.x) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            gameActivity.nativeSetSafezoneInfo(z17, gameActivity.safezoneF.left, GameActivity.this.safezoneF.top, GameActivity.this.safezoneF.right, GameActivity.this.safezoneF.bottom);
                        }
                        return windowInsets;
                    }
                });
                createVirtualKeyboardInput();
                this.mainView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.epicgames.ue4.GameActivity.11
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        int i27;
                        int i28;
                        int i29;
                        int i36;
                        boolean z17;
                        boolean z18;
                        if (GameActivity._activity == null) {
                            return;
                        }
                        GameActivity gameActivity = GameActivity.this;
                        if (gameActivity.newVirtualKeyboardInput != null && gameActivity.mainDecorView != null) {
                            Rect rect = new Rect();
                            GameActivity.this.mainDecorView.getWindowVisibleDisplayFrame(rect);
                            GameActivity.this.mainDecorView.getDrawingRect(GameActivity.this.mainDecorViewRect);
                            int abs = Math.abs(GameActivity.this.mainDecorViewRect.left - rect.left);
                            int abs2 = Math.abs(GameActivity.this.mainDecorViewRect.top - rect.top);
                            int abs3 = Math.abs(GameActivity.this.mainDecorViewRect.right - rect.right);
                            int abs4 = Math.abs(GameActivity.this.mainDecorViewRect.bottom - rect.bottom);
                            Rect rect2 = new Rect();
                            if (abs3 > 0) {
                                i27 = rect.right;
                            } else {
                                i27 = GameActivity.this.mainDecorViewRect.left;
                            }
                            rect2.left = i27;
                            if (abs4 > 0) {
                                i28 = rect.bottom;
                            } else {
                                i28 = GameActivity.this.mainDecorViewRect.top;
                            }
                            rect2.top = i28;
                            if (abs > 0) {
                                i29 = rect.left;
                            } else {
                                i29 = GameActivity.this.mainDecorViewRect.right;
                            }
                            rect2.right = i29;
                            if (abs2 > 0) {
                                i36 = rect.top;
                            } else {
                                i36 = GameActivity.this.mainDecorViewRect.bottom;
                            }
                            rect2.bottom = i36;
                            int height = rect.height() - GameActivity.this.newVirtualKeyboardInput.getHeight();
                            if (height < 0) {
                                height = rect.height() + GameActivity.this.newVirtualKeyboardInput.getHeight();
                            }
                            int max = Math.max(abs4, abs2);
                            if (max > 200) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (max >= 0 && max <= 200) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            if (!z17 && !z18) {
                                if (GameActivity.this.bKeyboardShowing) {
                                    GameActivity.this.nativeVirtualKeyboardShown(rect2.left, rect2.top, rect2.right, rect2.bottom);
                                    if (GameActivity.this.newVirtualKeyboardInput.getY() > 0.0f) {
                                        GameActivity.this.newVirtualKeyboardInput.setVisibility(8);
                                        GameActivity.this.newVirtualKeyboardInput.setY(-1000.0f);
                                    }
                                }
                                GameActivity.this.AndroidThunkJava_ResizeKeyboard(false, rect2, rect);
                                return;
                            }
                            if (GameActivity.this.bKeyboardShowing) {
                                GameActivity.this.nativeVirtualKeyboardShown(rect2.left, rect2.top, rect2.right, rect2.bottom);
                                GameActivity.this.newVirtualKeyboardInput.getLayoutParams().width = Math.abs(rect.right - rect.left);
                                GameActivity.this.newVirtualKeyboardInput.setX(0.0f);
                                GameActivity.this.newVirtualKeyboardInput.setY(height);
                                GameActivity.this.newVirtualKeyboardInput.setVisibility(8);
                                GameActivity.this.newVirtualKeyboardInput.setVisibility(0);
                                GameActivity.this.newVirtualKeyboardInput.requestFocus();
                            }
                            GameActivity.this.AndroidThunkJava_ResizeKeyboard(true, rect2, rect);
                        }
                    }
                });
            }
            if (UE4.hasOption(2)) {
                if (Build.VERSION.SDK_INT >= 29 && _thermalStatusChangedListener == null) {
                    _thermalStatusChangedListener = new PowerManager.OnThermalStatusChangedListener() { // from class: com.epicgames.ue4.GameActivity.12
                        @Override // android.os.PowerManager.OnThermalStatusChangedListener
                        public void onThermalStatusChanged(int i27) {
                            GameActivity.Log.debug("=== Thermal status changed to " + i27);
                            GameActivity.this.nativeOnThermalStatusChangedListener(null, i27);
                        }
                    };
                    ((PowerManager) getApplicationContext().getSystemService("power")).addThermalStatusListener(getMainExecutor(), _thermalStatusChangedListener);
                }
            } else if (Build.VERSION.SDK_INT >= 29) {
                ((PowerManager) getSystemService("power")).addThermalStatusListener(getMainExecutor(), new PowerManager.OnThermalStatusChangedListener() { // from class: com.epicgames.ue4.GameActivity.13
                    @Override // android.os.PowerManager.OnThermalStatusChangedListener
                    public void onThermalStatusChanged(int i27) {
                        GameActivity.Log.debug("=== Thermal status changed to " + i27);
                        GameActivity.this.nativeOnThermalStatusChangedListener(null, i27);
                    }
                });
            }
            UE4.profileEnd();
            UE4.profileBegin("Additions");
            UE4.profileBegin("GCloudCore");
            GCloudAppLifecycle gCloudAppLifecycle = GCloudAppLifecycle.Instance;
            gCloudAppLifecycle.addObserverByName("com.tencent.gcloud.GCloudAppLifecycleListener");
            gCloudAppLifecycle.onCreate(getApplicationContext());
            GCloudSDKRequestDynamicPermissions();
            UE4.profileEnd();
            UE4.profileBegin("GVoice");
            GCloudVoiceEngine.getInstance().init(getApplicationContext(), _activity);
            Log.i("GVoiceJava", "after java device init");
            UE4.profileEnd();
            UE4.profileEnd();
            UE4.profileBegin("FinalAdditions");
            UE4.profileBegin("CMShowUEInterface");
            if (isFirstCallingOnCreate() && (bundle3 = _extrasBundle) != null && bundle3.containsKey(UE4.AVATAR_VIEW_TYPE_KEY)) {
                Log.debug("==============> GameActivity.onCreate  call enterAvatarShow, " + _extrasBundle.getInt(UE4.AVATAR_VIEW_TYPE_KEY));
                UE4.enterAvatarShow(_extrasBundle.getInt(UE4.AVATAR_VIEW_TYPE_KEY));
            }
            if (this.networkStateChangedObserver == null && (bundle2 = _extrasBundle) != null && bundle2.containsKey(UE4.NET_STATE_CHANGED_KEY)) {
                InitNetStateChangeObserve();
            }
            UE4.profileEnd();
            UE4.profileEnd();
            Log.debug("==============> GameActive.onCreate complete!");
            UE4.profileEnd();
        }
    }

    public void AndroidThunkJava_GoogleClientConnect() {
    }

    public void AndroidThunkJava_GoogleClientDisconnect() {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    public void AndroidThunkJava_ClipboardCopy(String str) {
    }

    public void AndroidThunkJava_IapSetupService(String str) {
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
    }

    public void AndroidThunkJava_ResizeKeyboard(boolean z16, Rect rect, Rect rect2) {
    }

    @Override // com.epicgames.ue4.Logger.ILoggerCallback
    public void LoggerCallback(String str, String str2, String str3) {
    }

    public void AndroidThunkJava_OnRecordFrameCallback(char[] cArr, int i3, int i16, int i17, int i18) {
    }
}
