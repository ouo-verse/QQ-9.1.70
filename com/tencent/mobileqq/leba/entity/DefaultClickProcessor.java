package com.tencent.mobileqq.leba.entity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.leba.entity.DefaultClickProcessor;
import com.tencent.mobileqq.leba.redtouch.ILebaRedTouchReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00192\u00020\u0001:\u0002\u001d#B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J \u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0016R\u001b\u0010!\u001a\u00020\u00008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor;", "", "Lcom/tencent/mobileqq/leba/entity/n;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/leba/entity/f;", CacheTable.TABLE_NAME, "", "j", "Landroid/view/View;", "v", "i", "", tl.h.F, "", "e", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "Ljava/lang/Runnable;", "runnable", "k", "Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor$a;", "clickActionParam", "g", "view", "c", "Lcom/tencent/mobileqq/utils/ax;", "jumpAction", "f", "a", "Lkotlin/Lazy;", "d", "()Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor;", "clickProcessorProxy", "Lmqq/util/WeakReference;", "b", "Lmqq/util/WeakReference;", "actRef", "<init>", "()V", "qqleba-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public class DefaultClickProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy clickProcessorProxy;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile WeakReference<Activity> actRef;

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bS\u0010TR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010 \u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u000f\u0010\u001a\"\u0004\b\u001f\u0010\u001cR$\u0010$\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\"\u0010&\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0017\u0010\u001a\"\u0004\b%\u0010\u001cR$\u0010-\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b\u0003\u0010*\"\u0004\b+\u0010,R\"\u00104\u001a\u00020.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00106\u001a\u00020.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010/\u001a\u0004\b(\u00101\"\u0004\b5\u00103R$\u0010=\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010@\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b>\u0010\u001a\"\u0004\b?\u0010\u001cR$\u0010F\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010B\u001a\u0004\b\u001e\u0010C\"\u0004\bD\u0010ER$\u0010L\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010H\u001a\u0004\b!\u0010I\"\u0004\bJ\u0010KR$\u0010R\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010N\u001a\u0004\b\n\u0010O\"\u0004\bP\u0010Q\u00a8\u0006U"}, d2 = {"Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor$a;", "", "", "a", "Ljava/lang/String;", "l", "()Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Ljava/lang/String;)V", "url", "b", "g", "setName", "name", "", "c", ExifInterface.LATITUDE_SOUTH, "k", "()S", "y", "(S)V", "type", "", "d", "Z", DomainData.DOMAIN_NAME, "()Z", "u", "(Z)V", "isNew", "e", "r", "hasRedDot", "f", "i", "w", "redTouchInfo", ReportConstant.COSTREPORT_PREFIX, "hasRedFlag", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", tl.h.F, "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "()Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "p", "(Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;)V", "appInfo", "", "I", "j", "()I", HippyTKDListViewAdapter.X, "(I)V", "redType", "v", "redNum", "Landroid/view/View;", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "view", "o", "setQZone", "isQZone", "Lcom/tencent/mobileqq/leba/entity/n;", "Lcom/tencent/mobileqq/leba/entity/n;", "()Lcom/tencent/mobileqq/leba/entity/n;", "t", "(Lcom/tencent/mobileqq/leba/entity/n;)V", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/tianshu/api/IRedTouchManager;", "Lcom/tencent/mobileqq/tianshu/api/IRedTouchManager;", "()Lcom/tencent/mobileqq/tianshu/api/IRedTouchManager;", "setManager", "(Lcom/tencent/mobileqq/tianshu/api/IRedTouchManager;)V", "manager", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Landroid/os/Bundle;)V", "extras", "<init>", "()V", "qqleba-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String url;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String name;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private short type;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isNew;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean hasRedDot;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String redTouchInfo;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private boolean hasRedFlag;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private BusinessInfoCheckUpdate.AppInfo appInfo;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private int redType;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private int redNum;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private View view;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        private boolean isQZone;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private n item;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private IRedTouchManager manager;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Bundle extras;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Nullable
        public final BusinessInfoCheckUpdate.AppInfo a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (BusinessInfoCheckUpdate.AppInfo) iPatchRedirector.redirect((short) 16, (Object) this);
            }
            return this.appInfo;
        }

        @Nullable
        public final Bundle b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
                return (Bundle) iPatchRedirector.redirect((short) 30, (Object) this);
            }
            return this.extras;
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
            }
            return this.hasRedDot;
        }

        public final boolean d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
            }
            return this.hasRedFlag;
        }

        @Nullable
        public final n e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                return (n) iPatchRedirector.redirect((short) 26, (Object) this);
            }
            return this.item;
        }

        @Nullable
        public final IRedTouchManager f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
                return (IRedTouchManager) iPatchRedirector.redirect((short) 28, (Object) this);
            }
            return this.manager;
        }

        @Nullable
        public final String g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.name;
        }

        public final int h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
            }
            return this.redNum;
        }

        @Nullable
        public final String i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (String) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return this.redTouchInfo;
        }

        public final int j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
            }
            return this.redType;
        }

        public final short k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Short) iPatchRedirector.redirect((short) 6, (Object) this)).shortValue();
            }
            return this.type;
        }

        @Nullable
        public final String l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.url;
        }

        @Nullable
        public final View m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return (View) iPatchRedirector.redirect((short) 22, (Object) this);
            }
            return this.view;
        }

        public final boolean n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
            }
            return this.isNew;
        }

        public final boolean o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
            }
            return this.isQZone;
        }

        public final void p(@Nullable BusinessInfoCheckUpdate.AppInfo appInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                iPatchRedirector.redirect((short) 17, (Object) this, (Object) appInfo);
            } else {
                this.appInfo = appInfo;
            }
        }

        public final void q(@Nullable Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
                iPatchRedirector.redirect((short) 31, (Object) this, (Object) bundle);
            } else {
                this.extras = bundle;
            }
        }

        public final void r(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, z16);
            } else {
                this.hasRedDot = z16;
            }
        }

        public final void s(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, z16);
            } else {
                this.hasRedFlag = z16;
            }
        }

        public final void t(@Nullable n nVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
                iPatchRedirector.redirect((short) 27, (Object) this, (Object) nVar);
            } else {
                this.item = nVar;
            }
        }

        public final void u(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, z16);
            } else {
                this.isNew = z16;
            }
        }

        public final void v(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                iPatchRedirector.redirect((short) 21, (Object) this, i3);
            } else {
                this.redNum = i3;
            }
        }

        public final void w(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
            } else {
                this.redTouchInfo = str;
            }
        }

        public final void x(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                iPatchRedirector.redirect((short) 19, (Object) this, i3);
            } else {
                this.redType = i3;
            }
        }

        public final void y(short s16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Short.valueOf(s16));
            } else {
                this.type = s16;
            }
        }

        public final void z(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                this.url = str;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor$b;", "", "", "PREF_KEY_CHECK_APP_EXEMPTION", "Ljava/lang/String;", "PREF_NAME_CHECK_ENTER_APP", "TAG", "<init>", "()V", "qqleba-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.leba.entity.DefaultClickProcessor$b, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26885);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public DefaultClickProcessor() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(DefaultClickProcessor$clickProcessorProxy$2.INSTANCE);
            this.clickProcessorProxy = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final DefaultClickProcessor d() {
        return (DefaultClickProcessor) this.clickProcessorProxy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(n item, f reportInfo) {
        if (TianshuRedTouch.INSTANCE.j() && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106005", true)) {
            return;
        }
        ((ILebaRedTouchReportApi) QRoute.api(ILebaRedTouchReportApi.class)).reportLevelOneRedInfo((int) item.f240504a, 31, reportInfo.f240481e);
    }

    @NotNull
    public a c(@NotNull View view, @NotNull n item, @NotNull f reportInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (a) iPatchRedirector.redirect((short) 7, this, view, item, reportInfo);
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
        return d().c(view, item, reportInfo);
    }

    @NotNull
    public String e(@NotNull n item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) item);
        }
        Intrinsics.checkNotNullParameter(item, "item");
        String str = item.f240505b.strResName;
        Intrinsics.checkNotNullExpressionValue(str, "item.info.strResName");
        return str;
    }

    public void f(@NotNull n item, @NotNull ax jumpAction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) item, (Object) jumpAction);
        } else {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(jumpAction, "jumpAction");
        }
    }

    public void g(@NotNull Activity activity, @NotNull a clickActionParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity, (Object) clickActionParam);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(clickActionParam, "clickActionParam");
        d().g(activity, clickActionParam);
    }

    public boolean h(@NotNull n item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) item)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        return false;
    }

    public final void i(@NotNull final View v3, @NotNull final n item, @NotNull final f reportInfo) {
        Activity activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, v3, item, reportInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
        com.tencent.mobileqq.leba.util.a aVar = com.tencent.mobileqq.leba.util.a.f240763a;
        if (aVar.a()) {
            com.tencent.mobileqq.leba.util.a.c(new Runnable(v3, this, item, reportInfo) { // from class: com.tencent.mobileqq.leba.entity.DefaultClickProcessor$onPluginClick$$inlined$runOnWorkThread$1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ View f240434d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ n f240435e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ f f240436f;
                final /* synthetic */ DefaultClickProcessor this$0;

                {
                    this.f240434d = v3;
                    this.this$0 = this;
                    this.f240435e = item;
                    this.f240436f = reportInfo;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, v3, this, item, reportInfo);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Activity activity2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Context context = this.f240434d.getContext();
                    String str = null;
                    if (context instanceof Activity) {
                        activity2 = (Activity) context;
                    } else {
                        activity2 = null;
                    }
                    if (activity2 == null) {
                        QLog.e("Leba.DefaultClickProcessor", 1, "onPluginClick activity is null");
                        return;
                    }
                    this.this$0.actRef = new WeakReference(activity2);
                    SharedPreferences sharedPreferences = activity2.getSharedPreferences("laba_and_qwallet_check_enter", 4);
                    if (this.this$0.h(this.f240435e)) {
                        LebaPluginInfo lebaPluginInfo = this.f240435e.f240505b;
                        if (lebaPluginInfo != null) {
                            str = lebaPluginInfo.strGotoUrl;
                        }
                        if (!sharedPreferences.getBoolean(str, false)) {
                            DefaultClickProcessor defaultClickProcessor = this.this$0;
                            defaultClickProcessor.k(activity2, defaultClickProcessor.e(this.f240435e), new DefaultClickProcessor$onPluginClick$1$1(sharedPreferences, this.f240435e, this.this$0, this.f240434d, this.f240436f, activity2));
                            return;
                        }
                    }
                    if (com.tencent.mobileqq.leba.util.a.f240763a.a()) {
                        com.tencent.mobileqq.leba.util.a.c(new DefaultClickProcessor$onPluginClick$lambda$2$$inlined$runOnWorkThread$1(this.this$0, this.f240434d, this.f240435e, this.f240436f, activity2));
                        return;
                    }
                    DefaultClickProcessor.a c16 = this.this$0.c(this.f240434d, this.f240435e, this.f240436f);
                    this.this$0.j(this.f240435e, this.f240436f);
                    this.this$0.g(activity2, c16);
                }
            });
            return;
        }
        Context context = v3.getContext();
        String str = null;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            this.actRef = new WeakReference(activity);
            SharedPreferences sharedPreferences = activity.getSharedPreferences("laba_and_qwallet_check_enter", 4);
            if (h(item)) {
                LebaPluginInfo lebaPluginInfo = item.f240505b;
                if (lebaPluginInfo != null) {
                    str = lebaPluginInfo.strGotoUrl;
                }
                if (!sharedPreferences.getBoolean(str, false)) {
                    k(activity, e(item), new DefaultClickProcessor$onPluginClick$1$1(sharedPreferences, item, this, v3, reportInfo, activity));
                    return;
                }
            }
            if (aVar.a()) {
                com.tencent.mobileqq.leba.util.a.c(new DefaultClickProcessor$onPluginClick$lambda$2$$inlined$runOnWorkThread$1(this, v3, item, reportInfo, activity));
                return;
            }
            a c16 = c(v3, item, reportInfo);
            j(item, reportInfo);
            g(activity, c16);
            return;
        }
        QLog.e("Leba.DefaultClickProcessor", 1, "onPluginClick activity is null");
    }

    public void k(@NotNull Activity activity, @NotNull String businessName, @NotNull Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, activity, businessName, runnable);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        d().k(activity, businessName, runnable);
    }
}
