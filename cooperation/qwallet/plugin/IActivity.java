package cooperation.qwallet.plugin;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface IActivity {
    public static final String ACTION_KEY_EVENT = "action_key_event";
    public static final String ACTION_QWALLET_PATTERN_LOCK_COLSEALL = "pluginsdk_QWallet_PatternLock_closeAll";
    public static final String ACTION_TOUCH_EVENT = "action_touch_event";
    public static final String ACTION_TOUCH_START = "action_touch_start";
    public static final String EXTRA_KEY_EVENT = "extra_key_event";
    public static final String PARAM_DISABLE_PATTERN_LOCK = "pluginsdk_disable_PatternLock";
    public static final String PARAM_IS_USE_QWALLET_PATTERN_LOCK = "pluginsdk_is_Use_QWallet_PatternLock";
    public static final String PARAM_QWALLET_PLOCK_BG_INTVERAL_TIME = "pluginsdk_is_QWallet_PLock_Bg_interval_time";

    boolean isResume();
}
