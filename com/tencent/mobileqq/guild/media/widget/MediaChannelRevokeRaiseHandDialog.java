package com.tencent.mobileqq.guild.media.widget;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\f\u00a2\u0006\u0004\b\u0018\u0010\u0019J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/MediaChannelRevokeRaiseHandDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "", "onStart", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "qh", "()Ljava/lang/String;", "mTinyId", "D", "getName", "name", "E", "Landroid/view/ViewGroup;", "mRootView", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", UserInfo.SEX_FEMALE, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaChannelRevokeRaiseHandDialog extends BottomSheetDialogFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String mTinyId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String name;

    /* renamed from: E, reason: from kotlin metadata */
    private ViewGroup mRootView;

    public MediaChannelRevokeRaiseHandDialog(@NotNull String mTinyId, @NotNull String name) {
        Intrinsics.checkNotNullParameter(mTinyId, "mTinyId");
        Intrinsics.checkNotNullParameter(name, "name");
        this.mTinyId = mTinyId;
        this.name = name;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rh(MediaChannelRevokeRaiseHandDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String str;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.f168129ez1, container, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        this.mRootView = (ViewGroup) inflate;
        String k3 = MediaChannelUtils.f228046a.k(10, this.name);
        ViewGroup viewGroup = this.mRootView;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup = null;
        }
        TextView textView = (TextView) viewGroup.findViewById(R.id.f73783uh);
        Context context = getContext();
        if (context == null || (str = context.getString(R.string.f1496412u, k3)) == null) {
            str = "";
        }
        textView.setText(str);
        ViewGroup viewGroup3 = this.mRootView;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup3 = null;
        }
        View findViewById = viewGroup3.findViewById(R.id.f73763uf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById<TextureView>(R.id.revoke)");
        jt1.b.b(findViewById, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.MediaChannelRevokeRaiseHandDialog$onCreateView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (NetworkUtil.isNetworkAvailable()) {
                    com.tencent.mobileqq.guild.media.core.j.a().T().j1(MediaChannelRevokeRaiseHandDialog.this.getMTinyId(), new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.MediaChannelRevokeRaiseHandDialog$onCreateView$1.1
                        public final void invoke(int i3, @NotNull String msg2) {
                            Intrinsics.checkNotNullParameter(msg2, "msg");
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str2) {
                            invoke(num.intValue(), str2);
                            return Unit.INSTANCE;
                        }
                    });
                } else {
                    QQToast.makeText(BaseApplication.context, 0, "\u5f53\u524d\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\u3002", 0).show();
                }
                MediaChannelRevokeRaiseHandDialog.this.dismissAllowingStateLoss();
            }
        });
        ViewGroup viewGroup4 = this.mRootView;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup4 = null;
        }
        View findViewById2 = viewGroup4.findViewById(R.id.cancel);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById<TextureView>(R.id.cancel)");
        jt1.b.b(findViewById2, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.MediaChannelRevokeRaiseHandDialog$onCreateView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                MediaChannelRevokeRaiseHandDialog.this.dismissAllowingStateLoss();
            }
        });
        ViewGroup viewGroup5 = this.mRootView;
        if (viewGroup5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            viewGroup2 = viewGroup5;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, viewGroup2);
        return viewGroup2;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ViewGroup viewGroup = this.mRootView;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup = null;
        }
        ((ViewGroup) viewGroup.getRootView().findViewById(tp1.a.b())).setBackgroundResource(17170445);
        ViewGroup viewGroup3 = this.mRootView;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            viewGroup2 = viewGroup3;
        }
        viewGroup2.getRootView().findViewById(R.id.f100585sw).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.ba
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MediaChannelRevokeRaiseHandDialog.rh(MediaChannelRevokeRaiseHandDialog.this, view);
            }
        });
    }

    @NotNull
    /* renamed from: qh, reason: from getter */
    public final String getMTinyId() {
        return this.mTinyId;
    }
}
