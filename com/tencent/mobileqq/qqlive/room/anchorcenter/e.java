package com.tencent.mobileqq.qqlive.room.anchorcenter;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.SSODebugUtil;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0016J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0014\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0018\u0010!\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001aR\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010\u001a\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/anchorcenter/e;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View$OnClickListener;", "", "C9", "G9", "initData", "H9", "", "avatar", "J9", "nickName", "K9", "roomId", "L9", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/qqlive/room/anchorcenter/QQLiveAnchorCenterViewModel;", "d", "Lcom/tencent/mobileqq/qqlive/room/anchorcenter/QQLiveAnchorCenterViewModel;", "prepareViewModel", "e", "Landroid/view/View;", "navigateBackIcon", "f", "conversationIcon", tl.h.F, "manualServerIcon", "i", "messageIcon", "Lcom/tencent/mobileqq/widget/RoundImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/widget/RoundImageView;", "anchorAvatar", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "anchorNickname", "D", "anchorRoomId", "E", "redPointIcon", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class e extends Part implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TextView anchorNickname;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TextView anchorRoomId;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View redPointIcon;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQLiveAnchorCenterViewModel prepareViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View navigateBackIcon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View conversationIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View manualServerIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View messageIcon;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RoundImageView anchorAvatar;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void C9() {
        Long l3;
        if (this.messageIcon != null) {
            HashMap hashMap = new HashMap();
            QQLiveAnchorCenterViewModel qQLiveAnchorCenterViewModel = this.prepareViewModel;
            boolean z16 = false;
            if (qQLiveAnchorCenterViewModel != null && qQLiveAnchorCenterViewModel.S1() == 0) {
                z16 = true;
            }
            if (!z16) {
                QQLiveAnchorCenterViewModel qQLiveAnchorCenterViewModel2 = this.prepareViewModel;
                if (qQLiveAnchorCenterViewModel2 != null) {
                    l3 = Long.valueOf(qQLiveAnchorCenterViewModel2.S1());
                } else {
                    l3 = null;
                }
                hashMap.put("qqlive_taskid", String.valueOf(l3));
            }
            com.tencent.mobileqq.qqlive.sail.report.a aVar = com.tencent.mobileqq.qqlive.sail.report.a.f272382a;
            View view = this.messageIcon;
            Intrinsics.checkNotNull(view);
            com.tencent.mobileqq.qqlive.sail.report.a.d(aVar, view, false, null, "em_qqlive_msg_center_entrance", hashMap, 6, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(e this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J9(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(e this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K9(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(e this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L9(str);
    }

    private final void G9() {
        String str;
        if (SSODebugUtil.isTestEnv()) {
            str = "https://tde.qlive.qq.com/cos/live/h5/anchor-message/index.html?_tde_id=6881&_wv=2&anchorUid=" + com.tencent.mobileqq.qqlive.sail.c.f272176a.G();
        } else {
            str = "https://qlive.qq.com/cos/live/h5/anchor-message/index.html?_wv=2&_bid=5428&anchorUid=" + com.tencent.mobileqq.qqlive.sail.c.f272176a.G();
        }
        QLog.d(getTAG(), 1, "jumpToSocialOrderPage, url:" + str);
        Intent intent = new Intent(getActivity(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        intent.putExtra("url", str);
        getActivity().startActivity(intent);
    }

    private final void H9() {
        MutableLiveData<Boolean> mutableLiveData;
        Boolean bool;
        MutableLiveData<Boolean> U1;
        Intent intent;
        Boolean bool2;
        Intent intent2;
        MutableLiveData<Boolean> U12;
        QQLiveAnchorCenterViewModel qQLiveAnchorCenterViewModel = this.prepareViewModel;
        if (qQLiveAnchorCenterViewModel != null && (U12 = qQLiveAnchorCenterViewModel.U1()) != null) {
            U12.observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.qqlive.room.anchorcenter.d
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    e.I9(e.this, (Boolean) obj);
                }
            });
        }
        QQLiveAnchorCenterViewModel qQLiveAnchorCenterViewModel2 = this.prepareViewModel;
        Long l3 = null;
        if (qQLiveAnchorCenterViewModel2 != null) {
            mutableLiveData = qQLiveAnchorCenterViewModel2.U1();
        } else {
            mutableLiveData = null;
        }
        if (mutableLiveData != null) {
            Activity activity = getActivity();
            if (activity != null && (intent2 = activity.getIntent()) != null) {
                bool2 = Boolean.valueOf(intent2.getBooleanExtra("param_message_red_point", false));
            } else {
                bool2 = Boolean.FALSE;
            }
            mutableLiveData.setValue(bool2);
        }
        QQLiveAnchorCenterViewModel qQLiveAnchorCenterViewModel3 = this.prepareViewModel;
        if (qQLiveAnchorCenterViewModel3 != null) {
            Activity activity2 = getActivity();
            long j3 = 0;
            if (activity2 != null && (intent = activity2.getIntent()) != null) {
                j3 = intent.getLongExtra("param_red_point_taskid", 0L);
            }
            qQLiveAnchorCenterViewModel3.W1(j3);
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        String tag = getTAG();
        QQLiveAnchorCenterViewModel qQLiveAnchorCenterViewModel4 = this.prepareViewModel;
        if (qQLiveAnchorCenterViewModel4 != null && (U1 = qQLiveAnchorCenterViewModel4.U1()) != null) {
            bool = U1.getValue();
        } else {
            bool = null;
        }
        QQLiveAnchorCenterViewModel qQLiveAnchorCenterViewModel5 = this.prepareViewModel;
        if (qQLiveAnchorCenterViewModel5 != null) {
            l3 = Long.valueOf(qQLiveAnchorCenterViewModel5.S1());
        }
        companion.i(tag, "refreshRedPoint", "showRedPoint:" + bool + " taskId:" + l3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(e this$0, Boolean showRedPoint) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(showRedPoint, "showRedPoint");
        if (showRedPoint.booleanValue()) {
            View view = this$0.redPointIcon;
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        View view2 = this$0.redPointIcon;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    private final void J9(String avatar) {
        RoundImageView roundImageView;
        if (!TextUtils.isEmpty(avatar) && !TextUtils.equals("null", avatar) && (roundImageView = this.anchorAvatar) != null) {
            Intrinsics.checkNotNull(avatar);
            roundImageView.setImageDrawable(URLDrawable.getDrawable(avatar, (URLDrawable.URLDrawableOptions) null));
        }
    }

    private final void K9(String nickName) {
        TextView textView;
        if (nickName != null && (textView = this.anchorNickname) != null) {
            textView.setText(nickName);
        }
    }

    private final void L9(String roomId) {
        TextView textView;
        if (roomId != null && (textView = this.anchorRoomId) != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getActivity().getResources().getString(R.string.f210275ho);
            Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt\u2026hor_center_roomid_format)");
            String format = String.format(string, Arrays.copyOf(new Object[]{roomId}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView.setText(format);
        }
    }

    private final void initData() {
        MutableLiveData<String> T1;
        MutableLiveData<String> Q1;
        MutableLiveData<String> P1;
        QQLiveAnchorCenterViewModel qQLiveAnchorCenterViewModel = (QQLiveAnchorCenterViewModel) new ViewModelProvider(getHostFragment(), QQLiveAnchorCenterViewModel.INSTANCE.a()).get(QQLiveAnchorCenterViewModel.class);
        this.prepareViewModel = qQLiveAnchorCenterViewModel;
        if (qQLiveAnchorCenterViewModel != null && (P1 = qQLiveAnchorCenterViewModel.P1()) != null) {
            P1.observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.qqlive.room.anchorcenter.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    e.D9(e.this, (String) obj);
                }
            });
        }
        QQLiveAnchorCenterViewModel qQLiveAnchorCenterViewModel2 = this.prepareViewModel;
        if (qQLiveAnchorCenterViewModel2 != null && (Q1 = qQLiveAnchorCenterViewModel2.Q1()) != null) {
            Q1.observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.qqlive.room.anchorcenter.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    e.E9(e.this, (String) obj);
                }
            });
        }
        QQLiveAnchorCenterViewModel qQLiveAnchorCenterViewModel3 = this.prepareViewModel;
        if (qQLiveAnchorCenterViewModel3 != null && (T1 = qQLiveAnchorCenterViewModel3.T1()) != null) {
            T1.observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.qqlive.room.anchorcenter.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    e.F9(e.this, (String) obj);
                }
            });
        }
        H9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "Open_Live|QQLIveAnchorCenterNavigatePart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3);
        } else {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.f6327333) {
                getActivity().finish();
            } else if (num != null && num.intValue() == R.id.f637134_) {
                G9();
                C9();
                QQLiveAnchorCenterViewModel qQLiveAnchorCenterViewModel = this.prepareViewModel;
                if (qQLiveAnchorCenterViewModel != null) {
                    qQLiveAnchorCenterViewModel.N1();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        View view;
        View view2;
        View view3;
        RoundImageView roundImageView;
        TextView textView;
        TextView textView2;
        View view4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        View view5 = null;
        if (rootView != null) {
            view = rootView.findViewById(R.id.f6327333);
        } else {
            view = null;
        }
        this.navigateBackIcon = view;
        if (rootView != null) {
            view2 = rootView.findViewById(R.id.f6328334);
        } else {
            view2 = null;
        }
        this.conversationIcon = view2;
        if (rootView != null) {
            view3 = rootView.findViewById(R.id.f633433_);
        } else {
            view3 = null;
        }
        this.manualServerIcon = view3;
        if (rootView != null) {
            roundImageView = (RoundImageView) rootView.findViewById(R.id.f633933e);
        } else {
            roundImageView = null;
        }
        this.anchorAvatar = roundImageView;
        if (rootView != null) {
            textView = (TextView) rootView.findViewById(R.id.f633733c);
        } else {
            textView = null;
        }
        this.anchorNickname = textView;
        if (rootView != null) {
            textView2 = (TextView) rootView.findViewById(R.id.f633833d);
        } else {
            textView2 = null;
        }
        this.anchorRoomId = textView2;
        if (rootView != null) {
            view4 = rootView.findViewById(R.id.f637134_);
        } else {
            view4 = null;
        }
        this.messageIcon = view4;
        if (rootView != null) {
            view5 = rootView.findViewById(R.id.f61332xu);
        }
        this.redPointIcon = view5;
        View view6 = this.navigateBackIcon;
        if (view6 != null) {
            view6.setOnClickListener(this);
        }
        View view7 = this.conversationIcon;
        if (view7 != null) {
            view7.setVisibility(8);
        }
        View view8 = this.manualServerIcon;
        if (view8 != null) {
            view8.setVisibility(8);
        }
        View view9 = this.messageIcon;
        if (view9 != null) {
            view9.setOnClickListener(this);
        }
        initData();
    }
}
