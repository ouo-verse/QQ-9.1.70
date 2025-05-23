package com.qzone.reborn.albumx.qzonex.part.albummember;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.common.convert.bean.CommonClientAttr;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumMemberInitBean;
import com.qzone.reborn.base.k;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.data.base.UIStateData;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nc.ah;
import nc.ao;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000fH\u0016R\"\u0010\u001c\u001a\u00020\u000f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010$\u001a\u00020\u001d8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010(\u001a\u00020\u001d8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#\u00a8\u0006+"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/albummember/QZAlbumxAlbumMemberTitlePart;", "Lcom/qzone/reborn/base/k;", "", "initData", "Lya/a;", "rsp", "V9", "", "O9", "M9", "Lnc/ao;", "I9", "Lnc/ah;", "H9", "P9", "Landroid/view/View;", "view", "G9", "", "getLogTag", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "d", "Landroid/view/View;", "J9", "()Landroid/view/View;", "S9", "(Landroid/view/View;)V", "backIcon", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "L9", "()Landroid/widget/TextView;", "U9", "(Landroid/widget/TextView;)V", "titleTv", "f", "K9", "T9", "inviteTv", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxAlbumMemberTitlePart extends k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public View backIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public TextView titleTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public TextView inviteTv;

    private final void G9(View view) {
        fo.b bVar = new fo.b();
        bVar.k(ExposurePolicy.REPORT_NONE);
        fo.c.o(view, "em_qz_invite_btn", bVar);
    }

    private final ah H9() {
        return (ah) getViewModel(ah.class);
    }

    private final ao I9() {
        return (ao) getViewModel(ao.class);
    }

    private final void M9() {
        MutableLiveData<Boolean> O1;
        ah H9 = H9();
        if (H9 == null || (O1 = H9.O1()) == null) {
            return;
        }
        O1.postValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final boolean O9(ya.a rsp) {
        Iterator<CommonClientAttr> it = rsp.a().iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().getCooperation.qqcircle.report.QCircleAlphaUserReporter.KEY_USER java.lang.String().getUin(), LoginData.getInstance().getUinString())) {
                return true;
            }
        }
        return false;
    }

    private final boolean P9() {
        QZAlbumxAlbumMemberInitBean initBean;
        ao I9 = I9();
        return Intrinsics.areEqual((I9 == null || (initBean = I9.getInitBean()) == null) ? null : initBean.getShareAlbumOwnerUin(), String.valueOf(LoginData.getInstance().getUin()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(QZAlbumxAlbumMemberTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            activity.onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(QZAlbumxAlbumMemberTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.M9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V9(ya.a rsp) {
        ya.a albumMemberRsp;
        List<CommonClientAttr> a16;
        QZAlbumxAlbumMemberInitBean initBean;
        if (P9() || O9(rsp)) {
            ao I9 = I9();
            if (!((I9 == null || (initBean = I9.getInitBean()) == null || initBean.getPageType() != 4) ? false : true)) {
                K9().setVisibility(0);
                return;
            }
            ao I92 = I9();
            if (((I92 == null || (albumMemberRsp = I92.getAlbumMemberRsp()) == null || (a16 = albumMemberRsp.a()) == null) ? 0 : a16.size()) < 2) {
                K9().setVisibility(0);
            }
        }
    }

    private final void initData() {
        MutableLiveData<UIStateData<ya.a>> U1;
        ao I9 = I9();
        if (I9 == null || (U1 = I9.U1()) == null) {
            return;
        }
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<ya.a>, Unit> function1 = new Function1<UIStateData<ya.a>, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.albummember.QZAlbumxAlbumMemberTitlePart$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<ya.a> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<ya.a> uIStateData) {
                if (uIStateData == null || uIStateData.getData() == null) {
                    return;
                }
                QZAlbumxAlbumMemberTitlePart qZAlbumxAlbumMemberTitlePart = QZAlbumxAlbumMemberTitlePart.this;
                ya.a data = uIStateData.getData();
                Intrinsics.checkNotNullExpressionValue(data, "it.data");
                qZAlbumxAlbumMemberTitlePart.V9(data);
            }
        };
        U1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.albummember.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxAlbumMemberTitlePart.N9(Function1.this, obj);
            }
        });
    }

    public final View J9() {
        View view = this.backIcon;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("backIcon");
        return null;
    }

    public final TextView K9() {
        TextView textView = this.inviteTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("inviteTv");
        return null;
    }

    public final TextView L9() {
        TextView textView = this.titleTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("titleTv");
        return null;
    }

    public final void S9(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.backIcon = view;
    }

    public final void T9(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.inviteTv = textView;
    }

    public final void U9(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.titleTv = textView;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxAlbumMemberTitlePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.lck);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.iv_message_back)");
        S9(findViewById);
        J9().setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.albummember.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZAlbumxAlbumMemberTitlePart.Q9(QZAlbumxAlbumMemberTitlePart.this, view);
            }
        });
        View findViewById2 = rootView.findViewById(R.id.nhm);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.tv_album_member_title)");
        U9((TextView) findViewById2);
        L9().setText(getContext().getString(R.string.f134248a));
        View findViewById3 = rootView.findViewById(R.id.f162957nj2);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.tv_invite)");
        T9((TextView) findViewById3);
        K9().setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.albummember.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZAlbumxAlbumMemberTitlePart.R9(QZAlbumxAlbumMemberTitlePart.this, view);
            }
        });
        G9(K9());
        K9().setVisibility(8);
        initData();
    }
}
