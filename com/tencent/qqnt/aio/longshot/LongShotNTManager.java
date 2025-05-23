package com.tencent.qqnt.aio.longshot;

import NS_COMM.COMM;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOContact;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.Utils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.aio.event.MsgForwardEvent;
import com.tencent.mobileqq.aio.event.MultiSelectEvent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.widget.share.ShareActionSheetWithPreview;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ActionSheet;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import cooperation.qqfav.QfavBuilder;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 =2\u00020\u0001:\u0002=>B\u0007\u00a2\u0006\u0004\b;\u0010<J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J(\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J(\u0010\u0016\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J(\u0010\u0019\u001a\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J8\u0010 \u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0006H\u0002J\u0010\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!H\u0002J8\u0010%\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020\u0006H\u0002J\u0018\u0010)\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010+\u001a\u00020\b2\u0006\u0010*\u001a\u00020\rH\u0002J\u0018\u0010,\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010.\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010/\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u00100\u001a\u00020\u0004H\u0002J\u001e\u00101\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u00102\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u00104\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u000bJ(\u00105\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dJ:\u00106\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\u0006J\u001d\u00107\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b7\u00108J\u001e\u0010:\u001a\u00020\b2\u0006\u00109\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006?"}, d2 = {"Lcom/tencent/qqnt/aio/longshot/LongShotNTManager;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "t", "", "path", "", "w", "o", "Landroid/content/Intent;", "data", "", "forwardType", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/aio/longshot/LongShotNTManager$b;", "Lkotlin/collections/ArrayList;", "u", "", QCircleAlphaUserReporter.KEY_USER, "comment", "k", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contacts", "D", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "exitOnDismiss", "Lcom/tencent/qqnt/aio/adapter/api/c;", "exit", "subBusiness", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/widget/share/ShareActionSheetWithPreview;", "shareActionSheet", "y", "preView", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "filePathTmp", "Landroid/os/Bundle;", "p", UserInfo.SEX_FEMALE, "source", "v", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "j", "r", "I", "l", "activityResultData", HippyTKDListViewAdapter.X, "L", "M", ReportConstant.COSTREPORT_PREFIX, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toWeChatCircle", "H", "<init>", "()V", "a", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class LongShotNTManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f351200b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy<LongShotNTManager> f351201c;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\b\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/longshot/LongShotNTManager$a;", "", "Lcom/tencent/qqnt/aio/longshot/LongShotNTManager;", "a", "sInstance$delegate", "Lkotlin/Lazy;", "c", "()Lcom/tencent/qqnt/aio/longshot/LongShotNTManager;", "sInstance", "", "permissionSwitch$delegate", "b", "()Z", "permissionSwitch", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.longshot.LongShotNTManager$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        private final LongShotNTManager c() {
            return (LongShotNTManager) LongShotNTManager.f351201c.getValue();
        }

        @NotNull
        public final LongShotNTManager a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (LongShotNTManager) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return c();
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return ((Boolean) LongShotNTManager.f351200b.getValue()).booleanValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/longshot/LongShotNTManager$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "uin", "b", "I", "()I", "uinType", "<init>", "(Ljava/lang/String;I)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String uin;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int uinType;

        public b(@NotNull String uin, int i3) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) uin, i3);
            } else {
                this.uin = uin;
                this.uinType = i3;
            }
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.uin;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.uinType;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (Intrinsics.areEqual(this.uin, bVar.uin) && this.uinType == bVar.uinType) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return (this.uin.hashCode() * 31) + this.uinType;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "SelectContact(uin=" + this.uin + ", uinType=" + this.uinType + ")";
        }
    }

    static {
        Lazy<Boolean> lazy;
        Lazy<LongShotNTManager> lazy2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63646);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(LongShotNTManager$Companion$permissionSwitch$2.INSTANCE);
        f351200b = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(LongShotNTManager$Companion$sInstance$2.INSTANCE);
        f351201c = lazy2;
    }

    public LongShotNTManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(LongShotNTManager this$0, Activity activity, String path, com.tencent.qqnt.aio.adapter.api.c exit, Bitmap preView, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(path, "$path");
        Intrinsics.checkNotNullParameter(exit, "$exit");
        Intrinsics.checkNotNullParameter(preView, "$preView");
        shareActionSheet.dismiss();
        int i3 = actionSheetItem.action;
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 9) {
                    if (i3 != 10) {
                        if (i3 != 39) {
                            if (i3 == 171) {
                                this$0.F(activity, path);
                                exit.a();
                                this$0.j(activity);
                                return;
                            }
                            return;
                        }
                        this$0.v(6);
                        this$0.w(path, activity);
                        exit.a();
                        this$0.j(activity);
                        return;
                    }
                    this$0.v(4);
                    this$0.H(true, preView, path);
                    exit.a();
                    this$0.j(activity);
                    return;
                }
                this$0.H(false, preView, path);
                exit.a();
                this$0.j(activity);
                return;
            }
            this$0.G(activity, path);
            exit.a();
            this$0.j(activity);
            return;
        }
        this$0.o(activity, path);
        this$0.j(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(com.tencent.qqnt.aio.adapter.api.c exit, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(exit, "$exit");
        exit.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(com.tencent.qqnt.aio.adapter.api.c exit, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(exit, "$exit");
        exit.a();
    }

    private final void D(List<Contact> contacts, String comment, String path) {
        ArrayList<MsgElement> arrayListOf;
        MsgElement createTextElement;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(((IMsgUtilApi) QRoute.api(IMsgUtilApi.class)).createPicElement(path, true, 0));
        if (comment != null && (createTextElement = ((IMsgUtilApi) QRoute.api(IMsgUtilApi.class)).createTextElement(comment)) != null) {
            arrayListOf.add(createTextElement);
        }
        QLog.i("LongShotPicForwardManager", 1, "[share]: sendMsg, contacts size is " + contacts.size());
        for (Contact contact : contacts) {
            w e16 = com.tencent.qqnt.msg.f.e();
            if (e16 != null) {
                e16.F(0L, contact, arrayListOf, new IOperateCallback() { // from class: com.tencent.qqnt.aio.longshot.f
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str) {
                        LongShotNTManager.E(i3, str);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(int i3, String str) {
        QLog.d("LongShotPicForwardManager", 1, "ShareToUse: result->" + i3 + ", err->" + str);
    }

    private final void F(Activity activity, String path) {
        v(7);
        Intent intent = new Intent();
        intent.putExtras(p(path));
        ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).startQQGuildForwardGuildListFragment(activity, intent, 20000);
    }

    private final void G(Activity activity, String path) {
        v(2);
        QZoneHelper.forwardToPublishMood(activity, QZoneHelper.UserInfo.getInstance(), path, "", "", 18002);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(LongShotNTManager this$0, final Activity activity, final String path, com.tencent.qqnt.aio.adapter.api.c exit, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(path, "$path");
        Intrinsics.checkNotNullParameter(exit, "$exit");
        boolean z16 = true;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        AIOGalleryUtils.e(activity, path, 100);
                    }
                } else {
                    activity.runOnUiThread(new Runnable() { // from class: com.tencent.qqnt.aio.longshot.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            LongShotNTManager.K(path, activity);
                        }
                    });
                    exit.a();
                }
            } else {
                this$0.w(path, activity);
                if (INSTANCE.b() && this$0.t(activity)) {
                    z16 = false;
                } else {
                    exit.a();
                }
            }
        } else {
            this$0.o(activity, path);
        }
        if (z16) {
            actionSheet.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(String path, Activity activity) {
        Intrinsics.checkNotNullParameter(path, "$path");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        QfavBuilder.e0(path).h(activity, MobileQQ.sMobileQQ.peekAppRuntime().getAccount());
    }

    public static /* synthetic */ void N(LongShotNTManager longShotNTManager, Activity activity, Bitmap bitmap, String str, com.tencent.qqnt.aio.adapter.api.c cVar, boolean z16, String str2, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            str2 = "select_screenshot";
        }
        longShotNTManager.M(activity, bitmap, str, cVar, z16, str2);
    }

    private final void j(Activity activity) {
        if (q(activity)) {
            n(activity);
        }
    }

    private final void k(List<b> user, String comment, String path) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        ArrayList arrayList = new ArrayList();
        List<b> list = user;
        ArrayList<b> arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (!com.tencent.nt.adapter.session.c.e(((b) obj).b())) {
                arrayList2.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
        for (b bVar : arrayList2) {
            arrayList3.add(new Contact(com.tencent.nt.adapter.session.c.l(bVar.b()), bVar.a(), ""));
        }
        arrayList.addAll(arrayList3);
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : list) {
            if (com.tencent.nt.adapter.session.c.e(((b) obj2).b())) {
                arrayList4.add(obj2);
            }
        }
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList4, 10);
        ArrayList arrayList5 = new ArrayList(collectionSizeOrDefault2);
        Iterator it = arrayList4.iterator();
        while (it.hasNext()) {
            arrayList5.add(((b) it.next()).a());
        }
        if (arrayList5.isEmpty()) {
            D(arrayList, comment, path);
        }
        Iterator it5 = arrayList5.iterator();
        while (it5.hasNext()) {
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin((String) it5.next());
            ArrayList arrayList6 = new ArrayList();
            for (Object obj3 : list) {
                if (com.tencent.nt.adapter.session.c.e(((b) obj3).b())) {
                    arrayList6.add(obj3);
                }
            }
            Iterator it6 = arrayList6.iterator();
            while (it6.hasNext()) {
                int l3 = com.tencent.nt.adapter.session.c.l(((b) it6.next()).b());
                if (l3 == 10021) {
                    return;
                } else {
                    arrayList.add(new Contact(l3, uidFromUin, ""));
                }
            }
            D(arrayList, comment, path);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(Activity activity, Bitmap bitmap, String path, boolean exitOnDismiss, com.tencent.qqnt.aio.adapter.api.c exit, String subBusiness) {
        FragmentActivity fragmentActivity;
        AIOContact a16;
        String j3;
        Intent intent = activity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "activity.getIntent()");
        intent.putExtra("big_brother_source_key", "biz_src_qqagent");
        int screenHeight = ViewUtils.getScreenHeight();
        if (bitmap.getHeight() > screenHeight) {
            float height = screenHeight / bitmap.getHeight();
            bitmap = Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * height), (int) (bitmap.getHeight() * height), true);
        }
        Bitmap previewBitmap = bitmap;
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = activity;
        if (activity instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) activity;
        } else {
            fragmentActivity = null;
        }
        String str = "";
        if (fragmentActivity != null && (a16 = com.tencent.qqnt.aio.utils.a.f352276a.a(fragmentActivity)) != null && (j3 = a16.j()) != null) {
            str = j3;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("agent_uin", ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(str));
        hashMap.put("sub_biz_source", subBusiness);
        param.deReportParams = hashMap;
        ShareActionSheetWithPreview shareActionSheetWithPreview = new ShareActionSheetWithPreview(param);
        y(shareActionSheetWithPreview);
        shareActionSheetWithPreview.D0(previewBitmap);
        shareActionSheetWithPreview.setRowVisibility(8, 0, 0);
        Intrinsics.checkNotNullExpressionValue(previewBitmap, "previewBitmap");
        z(activity, shareActionSheetWithPreview, previewBitmap, path, exitOnDismiss, exit);
        shareActionSheetWithPreview.show();
    }

    private final void n(Activity activity) {
        FragmentActivity fragmentActivity;
        if (activity instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) activity;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity != null) {
            com.tencent.qqnt.aio.utils.c.f352293a.a(fragmentActivity, MsgForwardEvent.ExitMultiForward.f188621d);
        }
    }

    private final void o(Activity activity, String path) {
        Intent intent = new Intent(activity, (Class<?>) ForwardRecentActivity.class);
        intent.putExtras(new Bundle());
        intent.putExtra("forward_type", 1);
        intent.setData(Uri.parse(path));
        activity.startActivityForResult(intent, COMM.oidb_proxy_svr);
    }

    private final Bundle p(String filePathTmp) {
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 1);
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, filePathTmp);
        bundle.putString(AppConstants.Key.FORWARD_THUMB, filePathTmp);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, filePathTmp);
        bundle.putString(AppConstants.Key.FORWARD_EXTRA, filePathTmp);
        bundle.putBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
        bundle.putBoolean("isFromAIO", true);
        bundle.putInt(ForwardRecentActivity.SELECTION_MODE, 2);
        return bundle;
    }

    private final boolean q(Activity activity) {
        FragmentActivity fragmentActivity;
        if (activity instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) activity;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity == null) {
            return false;
        }
        MultiSelectEvent.GetSelectMode getSelectMode = new MultiSelectEvent.GetSelectMode(false, 1, null);
        com.tencent.qqnt.aio.utils.c.f352293a.a(fragmentActivity, getSelectMode);
        return getSelectMode.a();
    }

    private final boolean r() {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            return false;
        }
        return TabDataHelper.isExtendTabShow(BaseApplication.getContext(), str, "GUILD");
    }

    private final boolean t(Activity activity) {
        String[] strArr = {QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE};
        boolean z16 = false;
        for (int i3 = 0; i3 < 2; i3++) {
            if (activity.checkSelfPermission(strArr[i3]) != 0) {
                z16 = true;
            }
        }
        return z16;
    }

    private final ArrayList<b> u(Intent data, int forwardType) {
        ArrayList<b> arrayList = new ArrayList<>();
        ArrayList<ResultRecord> parcelableArrayListExtra = data.getParcelableArrayListExtra(AppConstants.Key.FORWARD_MULTI_TARGET);
        if (parcelableArrayListExtra != null) {
            for (ResultRecord resultRecord : parcelableArrayListExtra) {
                if (resultRecord.getUinType() == 10014) {
                    Intent intent = new Intent(data);
                    intent.putExtra("uin", resultRecord.uin);
                    intent.putExtra("uintype", resultRecord.getUinType());
                    intent.putExtra("troop_uin", resultRecord.groupUin);
                    intent.putExtra("uinname", resultRecord.name);
                    SessionInfo n06 = ForwardUtils.n0(intent);
                    Intrinsics.checkNotNullExpressionValue(n06, "sessionFromIntent(newIntent)");
                    ForwardUtils.K(n06, forwardType, data);
                } else {
                    String str = resultRecord.uin;
                    Intrinsics.checkNotNullExpressionValue(str, "target.uin");
                    arrayList.add(new b(str, resultRecord.uinType));
                }
            }
        } else {
            SessionInfo n07 = ForwardUtils.n0(data);
            Intrinsics.checkNotNullExpressionValue(n07, "sessionFromIntent(data)");
            if (n07.f179555d == 10014) {
                ForwardUtils.K(n07, forwardType, data);
            } else {
                String str2 = n07.f179557e;
                Intrinsics.checkNotNullExpressionValue(str2, "sessionInfo.curFriendUin");
                arrayList.add(new b(str2, n07.f179555d));
            }
        }
        return arrayList;
    }

    private final void v(int source) {
        HashMap hashMap = new HashMap();
        hashMap.put("share_source", Integer.valueOf(source));
        com.tencent.mobileqq.aio.utils.b.l("em_share_item", hashMap);
    }

    private final void w(String path, Activity activity) {
        File file = new File(path);
        AIOGalleryUtils.p(activity, file, Utils.Crc64String(file.getAbsolutePath()), null);
    }

    private final void y(ShareActionSheetWithPreview shareActionSheet) {
        ArrayList arrayList = new ArrayList();
        ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(2);
        Intrinsics.checkNotNullExpressionValue(build, "build(ShareActionSheetBu\u2026em.ACTION_SEND_TO_FRIEND)");
        arrayList.add(build);
        if (r()) {
            ShareActionSheetBuilder.ActionSheetItem build2 = ShareActionSheetBuilder.ActionSheetItem.build(171);
            Intrinsics.checkNotNullExpressionValue(build2, "build(ShareActionSheetBu\u2026m.ACTION_SEND_TO_CHANNEL)");
            arrayList.add(build2);
        }
        ShareActionSheetBuilder.ActionSheetItem build3 = ShareActionSheetBuilder.ActionSheetItem.build(3);
        Intrinsics.checkNotNullExpressionValue(build3, "build(ShareActionSheetBu\u2026tem.ACTION_SEND_TO_QZONE)");
        arrayList.add(build3);
        ShareActionSheetBuilder.ActionSheetItem build4 = ShareActionSheetBuilder.ActionSheetItem.build(9);
        Intrinsics.checkNotNullExpressionValue(build4, "build(ShareActionSheetBu\u2026em.ACTION_SEND_TO_WECHAT)");
        arrayList.add(build4);
        ShareActionSheetBuilder.ActionSheetItem build5 = ShareActionSheetBuilder.ActionSheetItem.build(10);
        Intrinsics.checkNotNullExpressionValue(build5, "build(ShareActionSheetBu\u2026ON_SEND_TO_WECHAT_CIRCLE)");
        arrayList.add(build5);
        ArrayList arrayList2 = new ArrayList();
        ShareActionSheetBuilder.ActionSheetItem build6 = ShareActionSheetBuilder.ActionSheetItem.build(39);
        Intrinsics.checkNotNullExpressionValue(build6, "build(ShareActionSheetBu\u2026ionSheetItem.ACTION_SAVE)");
        arrayList2.add(build6);
        shareActionSheet.setActionSheetItems(arrayList, arrayList2);
    }

    private final void z(final Activity activity, ShareActionSheetWithPreview shareActionSheet, final Bitmap preView, final String path, boolean exitOnDismiss, final com.tencent.qqnt.aio.adapter.api.c exit) {
        shareActionSheet.setItemClickListenerV2(new ShareActionSheet.OnItemClickListener() { // from class: com.tencent.qqnt.aio.longshot.b
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
            public final void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet2) {
                LongShotNTManager.A(LongShotNTManager.this, activity, path, exit, preView, actionSheetItem, shareActionSheet2);
            }
        });
        if (exitOnDismiss) {
            shareActionSheet.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.qqnt.aio.longshot.c
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    LongShotNTManager.B(com.tencent.qqnt.aio.adapter.api.c.this, dialogInterface);
                }
            });
            shareActionSheet.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.qqnt.aio.longshot.d
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    LongShotNTManager.C(com.tencent.qqnt.aio.adapter.api.c.this, dialogInterface);
                }
            });
        }
    }

    public final void H(boolean toWeChatCircle, @NotNull Bitmap preView, @NotNull String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(toWeChatCircle), preView, path);
            return;
        }
        Intrinsics.checkNotNullParameter(preView, "preView");
        Intrinsics.checkNotNullParameter(path, "path");
        if (!WXShareHelper.b0().e0()) {
            QLog.e("LongShotPicForwardManager", 1, "shareToWeChat failed, wx not installed");
            QQToastUtil.showQQToast(1, R.string.f173257ih1);
        } else if (!WXShareHelper.b0().f0()) {
            QLog.e("LongShotPicForwardManager", 1, "shareToWeChat failed, wx version too low");
            QQToastUtil.showQQToast(1, R.string.f173258ih2);
        } else {
            WXShareHelper.b0().w0(path, preView, toWeChatCircle ? 1 : 0, true);
        }
    }

    public final void I(@NotNull final Activity activity, @NotNull final String path, @NotNull final com.tencent.qqnt.aio.adapter.api.c exit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, path, exit);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(exit, "exit");
        final ActionSheet create = ActionSheet.create(activity);
        create.addButton(R.string.bsj);
        create.addButton(R.string.bst);
        create.addButton(R.string.bsh);
        create.addButton(R.string.bg6);
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.qqnt.aio.longshot.a
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                LongShotNTManager.J(LongShotNTManager.this, activity, path, exit, create, view, i3);
            }
        });
        create.show();
    }

    public final void L(@NotNull Activity activity, @Nullable Bitmap bitmap, @NotNull String path, @NotNull com.tencent.qqnt.aio.adapter.api.c exit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, activity, bitmap, path, exit);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(exit, "exit");
        N(this, activity, bitmap, path, exit, false, null, 32, null);
    }

    public final void M(@NotNull Activity activity, @Nullable Bitmap bitmap, @NotNull String path, @NotNull com.tencent.qqnt.aio.adapter.api.c exit, boolean exitOnDismiss, @NotNull String subBusiness) {
        LifecycleOwner lifecycleOwner;
        LifecycleCoroutineScope lifecycleScope;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, activity, bitmap, path, exit, Boolean.valueOf(exitOnDismiss), subBusiness);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(exit, "exit");
        Intrinsics.checkNotNullParameter(subBusiness, "subBusiness");
        if (bitmap == null) {
            if (activity instanceof LifecycleOwner) {
                lifecycleOwner = (LifecycleOwner) activity;
            } else {
                lifecycleOwner = null;
            }
            if (lifecycleOwner != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) != null) {
                CorountineFunKt.e(lifecycleScope, "LongShotPicForwardManager.showPreviewShareActionSheet", null, null, null, new LongShotNTManager$showPreviewShareActionSheet$1(this, path, activity, exitOnDismiss, exit, subBusiness, null), 14, null);
                return;
            }
            return;
        }
        m(activity, bitmap, path, exitOnDismiss, exit, subBusiness);
    }

    public final void l(@NotNull Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        int intExtra = data.getIntExtra("forward_type", Integer.MAX_VALUE);
        QLog.i("LongShotPicForwardManager", 1, "[doForward]: forwardType is " + intExtra);
        if (intExtra == Integer.MAX_VALUE) {
            return;
        }
        ArrayList<b> u16 = u(data, intExtra);
        data.getStringExtra(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE);
        String stringExtra = data.getStringExtra(AppConstants.Key.FORWARD_FILEPATH);
        if (stringExtra == null) {
            return;
        }
        k(u16, null, stringExtra);
    }

    @Nullable
    public final Object s(@NotNull String str, @NotNull Continuation<? super Bitmap> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) continuation);
        }
        return CorountineFunKt.i(i.d.f261782e, "LongShotPicForwardManager.loadPreviewBitmap", null, new LongShotNTManager$loadPreviewBitmap$2(str, null), continuation, 4, null);
    }

    public final void x(@NotNull Activity activity, @NotNull Intent activityResultData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity, (Object) activityResultData);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(activityResultData, "activityResultData");
        Intent intent = new Intent(activityResultData);
        intent.setClass(activity, SendPhotoActivity.class);
        intent.putExtra(AppConstants.Key.FORWARD_NT_LONG_SHOT_PIC, true);
        activity.startActivityForResult(intent, 18002);
    }
}
