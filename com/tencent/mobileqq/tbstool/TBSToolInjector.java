package com.tencent.mobileqq.tbstool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tbs.reader.tool.ITbsToolHost;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \t2\u00020\u0001:\u0001&B\t\b\u0002\u00a2\u0006\u0004\b3\u00104J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016J.\u0010\u0012\u001a\u00020\b2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u0016\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\u0018\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00172\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000fH\u0016J\"\u0010\u0019\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00172\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000fH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u0002H\u0016J$\u0010\u001e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u0013H\u0016J$\u0010 \u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u001fH\u0016J&\u0010!\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\"\u001a\u00020\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u0013H\u0016J$\u0010#\u001a\u00020\u001f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u001fH\u0016J$\u0010$\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u0002H\u0016R,\u0010,\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010%8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u00102\u001a\u00020\u001f8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/tbstool/TBSToolInjector;", "Lcom/tencent/tbs/reader/tool/ITbsToolHost;", "", "groupId", "key", "b", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "c", "d", "p0", "openFileCenter", "", "", "Landroid/webkit/ValueCallback;", "Ljava/lang/Void;", "p1", "showTips", "", MiniGamePAHippyBaseFragment.KEY_THEME, "url", "openWebPage", "Landroid/os/Bundle;", "saveToFileCenter", "openFile", "Landroid/content/Context;", "getApplicationContext", "getAuthority", "value", "saveBoolKv", "", "saveIntKv", "saveStringKv", "queryBoolValue", "queryIntValue", "queryStringValue", "Lmqq/util/WeakReference;", "a", "Lmqq/util/WeakReference;", "e", "()Lmqq/util/WeakReference;", "setCurActivity$qqfile_filebrowser_impl_release", "(Lmqq/util/WeakReference;)V", "curActivity", "I", "getEnterCount$qqfile_filebrowser_impl_release", "()I", "setEnterCount$qqfile_filebrowser_impl_release", "(I)V", "enterCount", "<init>", "()V", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class TBSToolInjector implements ITbsToolHost {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final TBSToolInjector f291406d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<Activity> curActivity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int enterCount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/tbstool/TBSToolInjector$a;", "", "Lcom/tencent/mobileqq/tbstool/TBSToolInjector;", "a", "", "KEY_TBS_TOOL_PREFIX", "Ljava/lang/String;", "TAG", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/mobileqq/tbstool/TBSToolInjector;", "<init>", "()V", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.tbstool.TBSToolInjector$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final TBSToolInjector a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return TBSToolInjector.f291406d;
            }
            return (TBSToolInjector) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22905);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            INSTANCE = new Companion(null);
            f291406d = new TBSToolInjector();
        }
    }

    TBSToolInjector() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String b(String groupId, String key) {
        return "tbs_tool_" + groupId + "_" + key;
    }

    public final void c(@NotNull Activity activity) {
        Activity activity2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        int max = Math.max(0, this.enterCount + 1);
        this.enterCount = max;
        QLog.d("TBSToolInjector", 1, "enterFileBrowserActivity enterCount: " + max + ", activity: " + activity);
        WeakReference<Activity> weakReference = this.curActivity;
        if (weakReference != null) {
            activity2 = weakReference.get();
        } else {
            activity2 = null;
        }
        if (activity2 != null) {
            return;
        }
        this.curActivity = new WeakReference<>(activity);
    }

    public final void d(@NotNull Activity activity) {
        Activity activity2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        int max = Math.max(0, this.enterCount - 1);
        this.enterCount = max;
        QLog.d("TBSToolInjector", 1, "exitFileBrowserActivity enterCount: " + max + ", activity: " + activity);
        if (this.enterCount <= 0) {
            WeakReference<Activity> weakReference = this.curActivity;
            if (weakReference != null) {
                activity2 = weakReference.get();
            } else {
                activity2 = null;
            }
            if (Intrinsics.areEqual(activity2, activity)) {
                this.curActivity = null;
            }
        }
    }

    @Nullable
    public final WeakReference<Activity> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (WeakReference) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.curActivity;
    }

    @Override // com.tencent.tbs.reader.tool.ITbsToolHost
    @NotNull
    public Context getApplicationContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Context) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        Context applicationContext = BaseApplication.context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        return applicationContext;
    }

    @Override // com.tencent.tbs.reader.tool.ITbsToolHost
    @NotNull
    public String getAuthority() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return "";
    }

    @Override // com.tencent.tbs.reader.tool.ITbsToolHost
    public boolean isNightMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return QQTheme.isNowThemeIsNight();
    }

    @Override // com.tencent.tbs.reader.tool.ITbsToolHost
    public void openFile(@Nullable Bundle p06, @Nullable ValueCallback<Boolean> p16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) p06, (Object) p16);
            return;
        }
        QLog.d("TBSToolInjector", 1, "openFile p0: " + p06);
        TBSToolClientUtils.f291401a.B(p06);
    }

    @Override // com.tencent.tbs.reader.tool.ITbsToolHost
    public void openFileCenter(@Nullable String p06) {
        WeakReference<Activity> weakReference;
        Activity activity;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) p06);
            return;
        }
        if (!TextUtils.isEmpty(p06) && (weakReference = this.curActivity) != null && (activity = weakReference.get()) != null) {
            try {
                Intrinsics.checkNotNull(p06);
                j3 = Long.parseLong(p06);
            } catch (Throwable th5) {
                QLog.d("TBSToolInjector", 1, th5, new Object[0]);
                j3 = 0;
            }
            ((IQQFileSelector) QRoute.api(IQQFileSelector.class)).jumpToMyFile(activity, j3);
        }
    }

    @Override // com.tencent.tbs.reader.tool.ITbsToolHost
    public void openWebPage(@Nullable String url) {
        WeakReference<Activity> weakReference;
        Activity activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) url);
            return;
        }
        if (!TextUtils.isEmpty(url) && (weakReference = this.curActivity) != null && (activity = weakReference.get()) != null) {
            Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", url);
            activity.startActivity(intent);
        }
    }

    @Override // com.tencent.tbs.reader.tool.ITbsToolHost
    public boolean queryBoolValue(@Nullable String groupId, @Nullable String key, boolean value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, this, groupId, key, Boolean.valueOf(value))).booleanValue();
        }
        if (!TextUtils.isEmpty(groupId) && !TextUtils.isEmpty(key)) {
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQ_FILE);
            Intrinsics.checkNotNull(groupId);
            Intrinsics.checkNotNull(key);
            return fromV2.decodeBool(b(groupId, key), value);
        }
        QLog.d("TBSToolInjector", 1, "queryBoolValue invalid param groupId: " + groupId + ",key: " + key + ",value: " + value);
        return value;
    }

    @Override // com.tencent.tbs.reader.tool.ITbsToolHost
    public int queryIntValue(@Nullable String groupId, @Nullable String key, int value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, this, groupId, key, Integer.valueOf(value))).intValue();
        }
        if (!TextUtils.isEmpty(groupId) && !TextUtils.isEmpty(key)) {
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQ_FILE);
            Intrinsics.checkNotNull(groupId);
            Intrinsics.checkNotNull(key);
            return fromV2.decodeInt(b(groupId, key), value);
        }
        QLog.d("TBSToolInjector", 1, "queryIntValue invalid param groupId: " + groupId + ",key: " + key + ",value: " + value);
        return value;
    }

    @Override // com.tencent.tbs.reader.tool.ITbsToolHost
    @NotNull
    public String queryStringValue(@Nullable String groupId, @Nullable String key, @NotNull String value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, this, groupId, key, value);
        }
        Intrinsics.checkNotNullParameter(value, "value");
        if (!TextUtils.isEmpty(groupId) && !TextUtils.isEmpty(key)) {
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQ_FILE);
            Intrinsics.checkNotNull(groupId);
            Intrinsics.checkNotNull(key);
            String decodeString = fromV2.decodeString(b(groupId, key), value);
            Intrinsics.checkNotNullExpressionValue(decodeString, "fromV2(MobileQQ.sMobileQ\u2026groupId!!, key!!), value)");
            return decodeString;
        }
        QLog.d("TBSToolInjector", 1, "queryStringValue invalid param groupId: " + groupId + ",key: " + key + ",value: " + value);
        return value;
    }

    @Override // com.tencent.tbs.reader.tool.ITbsToolHost
    public void saveBoolKv(@Nullable String groupId, @Nullable String key, boolean value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, groupId, key, Boolean.valueOf(value));
            return;
        }
        if (!TextUtils.isEmpty(groupId) && !TextUtils.isEmpty(key)) {
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQ_FILE);
            Intrinsics.checkNotNull(groupId);
            Intrinsics.checkNotNull(key);
            fromV2.putBoolean(b(groupId, key), value);
            return;
        }
        QLog.d("TBSToolInjector", 1, "saveBoolKv invalid param groupId: " + groupId + ",key: " + key + ",value: " + value);
    }

    @Override // com.tencent.tbs.reader.tool.ITbsToolHost
    public void saveIntKv(@Nullable String groupId, @Nullable String key, int value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, groupId, key, Integer.valueOf(value));
            return;
        }
        if (!TextUtils.isEmpty(groupId) && !TextUtils.isEmpty(key)) {
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQ_FILE);
            Intrinsics.checkNotNull(groupId);
            Intrinsics.checkNotNull(key);
            fromV2.putInt(b(groupId, key), value);
            return;
        }
        QLog.d("TBSToolInjector", 1, "saveIntKv invalid param groupId: " + groupId + ",key: " + key + ",value: " + value);
    }

    @Override // com.tencent.tbs.reader.tool.ITbsToolHost
    public void saveStringKv(@Nullable String groupId, @Nullable String key, @Nullable String value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, groupId, key, value);
            return;
        }
        if (!TextUtils.isEmpty(groupId) && !TextUtils.isEmpty(key)) {
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQ_FILE);
            Intrinsics.checkNotNull(groupId);
            Intrinsics.checkNotNull(key);
            fromV2.putString(b(groupId, key), value);
            return;
        }
        QLog.d("TBSToolInjector", 1, "saveStringKv invalid param groupId: " + groupId + ",key: " + key + ",value: " + value);
    }

    @Override // com.tencent.tbs.reader.tool.ITbsToolHost
    public void saveToFileCenter(@Nullable Bundle p06, @Nullable ValueCallback<Bundle> p16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) p06, (Object) p16);
            return;
        }
        QLog.d("TBSToolInjector", 1, "saveToFileCenter p0: " + p06);
        if (p06 == null) {
            return;
        }
        final long j3 = p06.getLong("fileId", 0L);
        String filePath = p06.getString("filePath", "");
        String srcFileName = p06.getString("srcFileName", "");
        if (!TextUtils.isEmpty(filePath) && !TextUtils.isEmpty(srcFileName)) {
            TBSToolClientUtils tBSToolClientUtils = TBSToolClientUtils.f291401a;
            Intrinsics.checkNotNullExpressionValue(filePath, "filePath");
            Intrinsics.checkNotNullExpressionValue(srcFileName, "srcFileName");
            tBSToolClientUtils.G(j3, filePath, srcFileName, p16, new Function1<FileManagerEntity, Unit>(j3) { // from class: com.tencent.mobileqq.tbstool.TBSToolInjector$saveToFileCenter$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $sessionId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$sessionId = j3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, j3);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FileManagerEntity fileManagerEntity) {
                    invoke2(fileManagerEntity);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull FileManagerEntity entity) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) entity);
                    } else {
                        Intrinsics.checkNotNullParameter(entity, "entity");
                        a.f291409a.a(this.$sessionId, entity);
                    }
                }
            });
        }
    }

    @Override // com.tencent.tbs.reader.tool.ITbsToolHost
    public void showTips(@Nullable Map<String, Object> p06, @Nullable ValueCallback<Void> p16) {
        Activity activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) p06, (Object) p16);
            return;
        }
        WeakReference<Activity> weakReference = this.curActivity;
        if (weakReference != null && (activity = weakReference.get()) != null) {
            TBSToolClientUtils.f291401a.J(activity, p06);
        }
    }
}
