package com.tencent.qqnt.forwardaio;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.RoundFrameLayout;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.kernel.api.ag;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetUinInfoCallback;
import com.tencent.qqnt.msg.f;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bH\u0002J&\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/forwardaio/ForwardMiniAIOFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "wh", "", "peerId", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "sh", "", "uin", "uh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "Landroidx/lifecycle/LifecycleOwner;", "getHostLifecycleOwner", "Lus/a;", BdhLogUtil.LogTag.Tag_Conn, "Lus/a;", "mAIOProvider", "<init>", "()V", "D", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class ForwardMiniAIOFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private us.a mAIOProvider;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/forwardaio/ForwardMiniAIOFragment$a;", "", "", "EVENT_KEY_BG_ID", "Ljava/lang/String;", "EVENT_UPDATE_BG", "", "NORMAL_AIO", UserInfo.SEX_FEMALE, "SCALE_AIO", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.forwardaio.ForwardMiniAIOFragment$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/forwardaio/ForwardMiniAIOFragment$b", "Lcom/tencent/aio/runtime/message/b;", "Landroid/os/Bundle;", "data", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements com.tencent.aio.runtime.message.b {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f356724b;

        b(Activity activity) {
            this.f356724b = activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardMiniAIOFragment.this, (Object) activity);
            }
        }

        @Override // com.tencent.aio.runtime.message.b
        public void a(@NotNull Bundle data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            int i3 = data.getInt("BG_ID", R.drawable.skin_mni_aio_bg_2);
            us.a aVar = ForwardMiniAIOFragment.this.mAIOProvider;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOProvider");
                aVar = null;
            }
            Drawable drawable = this.f356724b.getResources().getDrawable(i3);
            Intrinsics.checkNotNullExpressionValue(drawable, "activity.resources.getDrawable(resId)");
            aVar.k(drawable);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65631);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ForwardMiniAIOFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void sh(final String peerId, final AIOParam aioParam) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add(peerId);
        ag j3 = f.j();
        if (j3 != null) {
            j3.getUin(hashSet, new IKernelGetUinInfoCallback() { // from class: com.tencent.qqnt.forwardaio.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGetUinInfoCallback
                public final void onResult(HashMap hashMap) {
                    ForwardMiniAIOFragment.th(peerId, this, aioParam, hashMap);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void th(String peerId, ForwardMiniAIOFragment this$0, AIOParam aioParam, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(peerId, "$peerId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(aioParam, "$aioParam");
        QLog.i("ForwardMiniAIOFragment", 1, "[addUinToBundle]: convertUin result is " + hashMap.get(peerId));
        Long l3 = (Long) hashMap.get(peerId);
        if (l3 != null) {
            this$0.uh(l3.longValue(), aioParam);
        }
    }

    private final void uh(final long uin, final AIOParam aioParam) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.forwardaio.c
                @Override // java.lang.Runnable
                public final void run() {
                    ForwardMiniAIOFragment.vh(AIOParam.this, uin);
                }
            });
        } else {
            aioParam.l().putLong("key_peerUin", uin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(AIOParam aioParam, long j3) {
        Intrinsics.checkNotNullParameter(aioParam, "$aioParam");
        aioParam.l().putLong("key_peerUin", j3);
    }

    private final void wh(Activity activity) {
        String factoryName;
        int intExtra = activity.getIntent().getIntExtra("key_chat_type", 0);
        String stringExtra = activity.getIntent().getStringExtra("key_peerId");
        String stringExtra2 = activity.getIntent().getStringExtra("key_chat_name");
        if (stringExtra != null && stringExtra2 != null) {
            AIOSession aIOSession = new AIOSession(new AIOContact(intExtra, stringExtra, "", stringExtra2));
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_shield_item_touch", true);
            bundle.putBoolean("key_is_forward_aio", true);
            bundle.putInt("key_msg_head_padding", (int) activity.getResources().getDimension(R.dimen.bzh));
            bundle.putAll(activity.getIntent().getExtras());
            boolean booleanExtra = activity.getIntent().getBooleanExtra("key_forward_aio_show_custom_msg", false);
            if (booleanExtra) {
                factoryName = d.class.getName();
            } else {
                factoryName = a.class.getName();
            }
            if (booleanExtra) {
                bundle.putBoolean("key_is_forward_preview_aio", true);
            }
            AIOParam.a i3 = new AIOParam.a().i(true);
            Intrinsics.checkNotNullExpressionValue(factoryName, "factoryName");
            AIOParam c16 = i3.e(factoryName).a(bundle).h(aIOSession).c();
            com.tencent.aio.main.engine.b bVar = com.tencent.aio.main.engine.b.f69377a;
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            us.a c17 = bVar.c(c16, childFragmentManager, R.id.f165270ve0, null);
            Drawable drawable = activity.getResources().getDrawable(R.drawable.skin_mni_aio_bg_2);
            Intrinsics.checkNotNullExpressionValue(drawable, "activity.resources.getDr\u2026awable.skin_mni_aio_bg_2)");
            c17.k(drawable);
            this.mAIOProvider = c17;
            c17.i("EVENT_UPDATE_BG", new b(activity));
            sh(stringExtra, c16);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    /* renamed from: getHostLifecycleOwner */
    public LifecycleOwner getLifecycleOwner() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LifecycleOwner) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return getViewLifecycleOwner();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            view = (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            FragmentActivity activity = getActivity();
            if (activity == null) {
                view = null;
            } else {
                ConstraintLayout constraintLayout = new ConstraintLayout(activity);
                constraintLayout.setBackground(null);
                constraintLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                RoundFrameLayout roundFrameLayout = new RoundFrameLayout(activity);
                roundFrameLayout.setId(R.id.f165270ve0);
                roundFrameLayout.setScaleX(0.78f);
                roundFrameLayout.setScaleY(0.78f);
                roundFrameLayout.setCorners(15);
                roundFrameLayout.setRadius((int) requireContext().getResources().getDimension(R.dimen.bzn));
                ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, (int) (activity.getResources().getDisplayMetrics().heightPixels * 0.86f));
                layoutParams.bottomToBottom = 0;
                layoutParams.topToTop = 0;
                layoutParams.startToStart = 0;
                layoutParams.endToEnd = 0;
                constraintLayout.addView(roundFrameLayout, layoutParams);
                wh(activity);
                view = constraintLayout;
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }
}
