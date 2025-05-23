package nu0;

import com.tencent.mobileqq.icgame.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.raft.raftframework.sla.SLAReporter;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f421286a = QQLiveSDKConfigHelper.getQQLiveAppId();

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f421287b = {SLAReporter.PERMISSION_NET, "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE"};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f421288c = {SLAReporter.PERMISSION_NET, "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE", QQPermissionConstants.Permission.RECORD_AUDIO, "android.permission.MODIFY_AUDIO_SETTINGS", "android.permission.BLUETOOTH", QQPermissionConstants.Permission.CAMERA};
}
