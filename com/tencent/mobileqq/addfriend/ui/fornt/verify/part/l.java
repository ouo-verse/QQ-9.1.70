package com.tencent.mobileqq.addfriend.ui.fornt.verify.part;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.addfriend.handler.NTAddFriendHandler;
import com.tencent.mobileqq.addfriend.ui.fornt.verify.AddFriendVerifyFragmentForNT;
import com.tencent.mobileqq.addfriend.widget.FlowLabelLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.LabelTag;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.AccountInfo;
import com.tencent.qqnt.kernel.nativeinterface.BuddyInfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGetBuddyInfoCallback;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u00014\u0018\u0000 >2\u00020\u0001:\u0001?B\u0007\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0012\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\fH\u0002J\u001a\u0010 \u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0012\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0012\u0010$\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016R\u0018\u0010'\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/l;", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/v;", "", "oa", "initData", "Ea", "za", "pa", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "va", "xa", "", "uin", "Ba", "Lcom/tencent/qqnt/kernel/api/f;", "ua", "na", "Lcom/tencent/mobileqq/data/LabelTag;", "tag", "Landroid/view/View;", "wa", "view", "Landroid/widget/TextView;", "textView", "Aa", "name", "Fa", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "ta", "Lcom/tencent/mobileqq/data/Friends;", "sa", "onPartDestroy", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/TextView;", "mNameTxt", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/ImageView;", "portraitImage", "Lcom/tencent/mobileqq/addfriend/widget/FlowLabelLayout;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/addfriend/widget/FlowLabelLayout;", "mFlowLabel", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/b;", "T", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/b;", "mAddFriendHeaderViewModel", "com/tencent/mobileqq/addfriend/ui/fornt/verify/part/l$c", "U", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/l$c;", "mAddFriendObserver", "Lcom/tencent/qidian/controller/c;", "V", "Lcom/tencent/qidian/controller/c;", "mQiDianBusinessObserver", "<init>", "()V", "W", "a", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class l extends v {
    static IPatchRedirector $redirector_;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private TextView mNameTxt;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private ImageView portraitImage;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private FlowLabelLayout mFlowLabel;

    /* renamed from: T, reason: from kotlin metadata */
    private com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.b mAddFriendHeaderViewModel;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private c mAddFriendObserver;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.qidian.controller.c mQiDianBusinessObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/l$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.l$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/addfriend/ui/fornt/verify/part/l$b", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "urlDrawable", "", "throwable", "onLoadFialed", "onLoadCanceled", "", "i", "onLoadProgressed", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@NotNull URLDrawable urlDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) urlDrawable);
            } else {
                Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@NotNull URLDrawable urlDrawable, @NotNull Throwable throwable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) urlDrawable, (Object) throwable);
            } else {
                Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
                Intrinsics.checkNotNullParameter(throwable, "throwable");
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@NotNull URLDrawable urlDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) urlDrawable, i3);
            } else {
                Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@NotNull URLDrawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable);
                return;
            }
            Intrinsics.checkNotNullParameter(drawable, "drawable");
            Bitmap e16 = com.tencent.mobileqq.avatar.utils.c.e(BaseImageUtil.drawabletoBitmap(drawable), 50, 50);
            ImageView imageView = l.this.portraitImage;
            if (imageView != null) {
                imageView.setImageDrawable(new BitmapDrawable(e16));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0014J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/addfriend/ui/fornt/verify/part/l$c", "Lcom/tencent/mobileqq/addfriend/observer/a;", "", "isSuccess", "", "uin", "name", "", "f", "", "data", "a", "b", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c extends com.tencent.mobileqq.addfriend.observer.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
            }
        }

        @Override // com.tencent.mobileqq.addfriend.observer.a
        public void a(@NotNull Object data) {
            List list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            FlowLabelLayout flowLabelLayout = l.this.mFlowLabel;
            if (flowLabelLayout != null) {
                flowLabelLayout.removeAllViews();
            }
            if (data instanceof List) {
                list = (List) data;
            } else {
                list = null;
            }
            if (list == null) {
                return;
            }
            if (list.isEmpty()) {
                l.this.na();
                return;
            }
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                LabelTag labelTag = (LabelTag) list.get(i3);
                FlowLabelLayout flowLabelLayout2 = l.this.mFlowLabel;
                if (flowLabelLayout2 != null) {
                    flowLabelLayout2.addView(l.this.wa(labelTag));
                }
            }
        }

        @Override // com.tencent.mobileqq.addfriend.observer.a
        public void b(@NotNull Object data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            if ((data instanceof String) && !TextUtils.isEmpty((CharSequence) data)) {
                l.this.Fa((String) data);
            }
        }

        @Override // com.tencent.mobileqq.addfriend.observer.a
        protected void f(boolean isSuccess, @Nullable String uin, @Nullable String name) {
            TextView textView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), uin, name);
                return;
            }
            if (!l.this.W9() && isSuccess && TextUtils.equals(uin, l.this.D9()) && !TextUtils.isEmpty(name)) {
                l.this.Fa(name);
                if (AddFriendVerifyFragmentForNT.T && (textView = l.this.mNameTxt) != null) {
                    textView.setContentDescription(name);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007H\u0014\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/addfriend/ui/fornt/verify/part/l$d", "Lcom/tencent/qidian/controller/c;", "", "isSuccess", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "data", "", "a", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class d extends com.tencent.qidian.controller.c {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
            }
        }

        @Override // com.tencent.qidian.controller.c
        protected void a(boolean isSuccess, @NotNull HashMap<String, Object> data) {
            CharSequence charSequence;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            if (isSuccess && ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).hasQidianExternal(data)) {
                HashMap<String, String> qidianExternal = ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).getQidianExternal(data);
                if (qidianExternal != null && Intrinsics.areEqual(l.this.D9(), qidianExternal.get("qidian_uin"))) {
                    if (l.this.mNameTxt != null) {
                        TextView textView = l.this.mNameTxt;
                        if (textView != null) {
                            charSequence = textView.getText();
                        } else {
                            charSequence = null;
                        }
                        String valueOf = String.valueOf(charSequence);
                        if (TextUtils.isEmpty(valueOf) || Intrinsics.areEqual(valueOf, l.this.D9())) {
                            l.this.Fa(qidianExternal.get("qidian_nickname"));
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("AddFriendHeaderPart", 2, "onGetQiDianMasterInfo not current uin");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AddFriendHeaderPart", 2, "onGetQiDianMasterInfo fail");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23547);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mAddFriendObserver = new c();
            this.mQiDianBusinessObserver = new d();
        }
    }

    private final void Aa(View view, TextView textView) {
        if (QQTheme.isNowThemeIsNight()) {
            view.setBackgroundResource(R.drawable.j3_);
            textView.setTextColor(Color.parseColor("#8D8D93"));
        }
    }

    private final void Ba(String uin) {
        Long l3;
        if (TextUtils.isEmpty(uin)) {
            QLog.i("AddFriendHeaderPart", 1, "uin is empty");
            return;
        }
        AccountInfo accountInfo = new AccountInfo();
        if (uin != null) {
            l3 = Long.valueOf(Long.parseLong(uin));
        } else {
            l3 = null;
        }
        accountInfo.uin = l3;
        com.tencent.qqnt.kernel.api.f ua5 = ua();
        if (ua5 != null) {
            byte[] bytes = "".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            ua5.requestInfoByAccount("AddFriendHeaderPart", accountInfo, bytes, new IGetBuddyInfoCallback() { // from class: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.j
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetBuddyInfoCallback
                public final void onResult(int i3, String str, byte[] bArr, AccountInfo accountInfo2, BuddyInfoRsp buddyInfoRsp) {
                    l.Ca(l.this, i3, str, bArr, accountInfo2, buddyInfoRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ca(final l this$0, int i3, String str, byte[] bArr, AccountInfo accountInfo, final BuddyInfoRsp buddyInfoRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("AddFriendHeaderPart", 1, "result = " + i3 + " errMsg = " + str);
        if (i3 != 0) {
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.k
            @Override // java.lang.Runnable
            public final void run() {
                l.Da(l.this, buddyInfoRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Da(l this_run, BuddyInfoRsp buddyInfoRsp) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        this_run.Fa(buddyInfoRsp.getNick());
    }

    private final void Ea() {
        long j3;
        if (B9() != null) {
            try {
                String D9 = D9();
                if (D9 != null) {
                    j3 = Long.parseLong(D9);
                } else {
                    j3 = 0;
                }
                NTAddFriendHandler B9 = B9();
                if (B9 != null) {
                    B9.K2(A9(), "", j3);
                }
            } catch (NumberFormatException unused) {
                if (QLog.isColorLevel()) {
                    QLog.i("AddFriendHeaderPart", 1, "requestAddFriendTag long parse error");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Fa(String name) {
        String str;
        CharSequence text;
        TextView textView = this.mNameTxt;
        if (textView != null) {
            if (name != null) {
                textView.setText(name);
            } else {
                return;
            }
        }
        com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.b bVar = this.mAddFriendHeaderViewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddFriendHeaderViewModel");
            bVar = null;
        }
        TextView textView2 = this.mNameTxt;
        if (textView2 == null || (text = textView2.getText()) == null || (str = text.toString()) == null) {
            str = "";
        }
        bVar.N1(str);
    }

    private final void initData() {
        ViewModel viewModel = getViewModel(com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(AddFriendHeaderViewModel::class.java)");
        this.mAddFriendHeaderViewModel = (com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.b) viewModel;
        Integer P9 = P9();
        if (P9 != null && P9.intValue() == 1) {
            Ea();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void na() {
        TextView textView = this.mNameTxt;
        if (textView != null) {
            textView.setPadding(0, 0, 0, 0);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        TextView textView2 = this.mNameTxt;
        if (textView2 != null) {
            textView2.setLayoutParams(layoutParams);
        }
    }

    private final void oa() {
        AppInterface z95 = z9();
        if (z95 == null) {
            return;
        }
        z95.addObserver(this.mAddFriendObserver);
        z95.addObserver(this.mQiDianBusinessObserver);
    }

    private final void pa() {
        final String str;
        String str2;
        NTAddFriendHandler B9;
        TextView textView;
        Bundle extras;
        Intent intent = getIntent();
        String str3 = null;
        if (intent != null && (extras = intent.getExtras()) != null) {
            str = extras.getString(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
        } else {
            str = null;
        }
        Integer P9 = P9();
        if (P9 != null && P9.intValue() == 3) {
            Intent intent2 = getIntent();
            if (intent2 != null) {
                str2 = intent2.getStringExtra("extra");
            } else {
                str2 = null;
            }
            va(URLDrawable.getDrawable(FaceDrawable.getOpenIdUrl(D9(), str2), URLDrawable.URLDrawableOptions.obtain()));
            TextView textView2 = this.mNameTxt;
            if (textView2 != null) {
                textView2.setText(str);
            }
            if (AddFriendVerifyFragmentForNT.T && (textView = this.mNameTxt) != null) {
                textView.setContentDescription(str);
            }
            if (B9() != null && (B9 = B9()) != null) {
                String A9 = A9();
                String D9 = D9();
                Intent intent3 = getIntent();
                if (intent3 != null) {
                    str3 = intent3.getStringExtra("extra");
                }
                B9.M2(A9, D9, str3);
            }
        } else {
            ImageView imageView = this.portraitImage;
            if (imageView != null) {
                imageView.setImageDrawable(FaceDrawable.getFaceDrawable(z9(), 1, D9()));
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.h
                @Override // java.lang.Runnable
                public final void run() {
                    l.qa(l.this, str);
                }
            }, 32, null, true);
        }
        if (K9() || J9() || I9()) {
            xa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qa(final l this$0, final String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final String ta5 = this$0.ta(this$0.D9());
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.i
            @Override // java.lang.Runnable
            public final void run() {
                l.ra(l.this, str, ta5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ra(l this$0, String str, String str2) {
        TextView textView;
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView2 = this$0.mNameTxt;
        boolean z16 = false;
        if (textView2 != null && true == textView2.isShown()) {
            z16 = true;
        }
        if (z16) {
            if (TextUtils.isEmpty(str)) {
                str = str2;
            }
            this$0.Fa(str);
            if (AddFriendVerifyFragmentForNT.T && (textView = this$0.mNameTxt) != null) {
                if (textView != null) {
                    charSequence = textView.getText();
                } else {
                    charSequence = null;
                }
                textView.setContentDescription(charSequence);
            }
        }
    }

    private final com.tencent.qqnt.kernel.api.f ua() {
        IKernelService iKernelService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")) != null) {
            return iKernelService.getAddOrDelBuddyService();
        }
        return null;
    }

    private final void va(URLDrawable urlDrawable) {
        if (urlDrawable != null && z9() != null && this.portraitImage != null) {
            Bitmap drawabletoBitmap = BaseImageUtil.drawabletoBitmap(urlDrawable);
            if (urlDrawable.getStatus() == 1) {
                Bitmap e16 = com.tencent.mobileqq.avatar.utils.c.e(drawabletoBitmap, 50, 50);
                ImageView imageView = this.portraitImage;
                if (imageView != null) {
                    imageView.setImageDrawable(new BitmapDrawable(e16));
                    return;
                }
                return;
            }
            urlDrawable.setURLDrawableListener(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View wa(LabelTag tag) {
        View labelView = LayoutInflater.from(getContext()).inflate(R.layout.dro, (ViewGroup) null);
        View findViewById = labelView.findViewById(R.id.ycf);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) findViewById;
        View findViewById2 = labelView.findViewById(R.id.yck);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById2;
        if (!TextUtils.isEmpty(tag.getIcon())) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = ResourcesCompat.getDrawable(getActivity().getResources(), R.color.ajr, null);
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            imageView.setImageDrawable(URLDrawable.getDrawable(tag.getIcon(), obtain));
        } else {
            imageView.setVisibility(8);
        }
        if (!TextUtils.isEmpty(tag.getText())) {
            textView.setText(tag.getText());
        } else {
            textView.setVisibility(8);
        }
        Intrinsics.checkNotNullExpressionValue(labelView, "labelView");
        Aa(labelView, textView);
        return labelView;
    }

    private final void xa() {
        ImageView imageView = this.portraitImage;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = this.mNameTxt;
        if (textView != null) {
            textView.setVisibility(8);
        }
        FlowLabelLayout flowLabelLayout = this.mFlowLabel;
        if (flowLabelLayout != null) {
            flowLabelLayout.setVisibility(8);
        }
    }

    private final void za() {
        ImageView imageView;
        TextView textView;
        View findViewById = getPartRootView().findViewById(R.id.fxg);
        FlowLabelLayout flowLabelLayout = null;
        if (findViewById instanceof ImageView) {
            imageView = (ImageView) findViewById;
        } else {
            imageView = null;
        }
        this.portraitImage = imageView;
        View findViewById2 = getPartRootView().findViewById(R.id.nickname);
        if (findViewById2 instanceof TextView) {
            textView = (TextView) findViewById2;
        } else {
            textView = null;
        }
        this.mNameTxt = textView;
        View findViewById3 = getPartRootView().findViewById(R.id.f165250vc2);
        if (findViewById3 instanceof FlowLabelLayout) {
            flowLabelLayout = (FlowLabelLayout) findViewById3;
        }
        this.mFlowLabel = flowLabelLayout;
    }

    @Override // com.tencent.mobileqq.addfriend.ui.fornt.verify.part.v, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        oa();
        initData();
        za();
        pa();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        AppInterface z95 = z9();
        if (z95 == null) {
            return;
        }
        z95.removeObserver(this.mAddFriendObserver);
        z95.removeObserver(this.mQiDianBusinessObserver);
    }

    @Nullable
    public final Friends sa(@Nullable String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Friends) iPatchRedirector.redirect((short) 4, (Object) this, (Object) uin);
        }
        if (Friends.isValidUin(uin) && MobileQQ.sMobileQQ.peekAppRuntime() != null) {
            IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFriendDataService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026ssConstant.MAIN\n        )");
            return ((IFriendDataService) runtimeService).getFriend(uin, true, true);
        }
        return null;
    }

    @Nullable
    public final String ta(@Nullable String uin) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) uin);
        }
        Friends sa5 = sa(uin);
        if (sa5 != null) {
            str = sa5.alias;
        } else {
            str = null;
        }
        if (str != null && sa5.alias.length() > 0) {
            return sa5.alias;
        }
        Ba(uin);
        return uin;
    }
}
