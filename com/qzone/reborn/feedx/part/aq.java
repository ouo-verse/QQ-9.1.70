package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.leba.ILebaUIStyleSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.resconfig.MainResourceConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.TokenResUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/feedx/part/aq;", "Lcom/qzone/reborn/feedx/part/QZoneFriendFeedTitlePart;", "", "aa", "ca", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "S9", "", "T9", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class aq extends QZoneFriendFeedTitlePart {
    private final void aa() {
        fo.c.n(L9().f(new uh.d(TokenResUtils.getTokenRes(R.drawable.f162370o00, R.drawable.f162370o00), null, new View.OnClickListener() { // from class: com.qzone.reborn.feedx.part.ap
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                aq.ba(aq.this, view);
            }
        }, null, null, false, 58, null)), "em_setting_button");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(aq this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.qzone.util.h.a()) {
            this$0.ca();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void ca() {
        ILebaUIStyleSettingApi iLebaUIStyleSettingApi = (ILebaUIStyleSettingApi) QRoute.api(ILebaUIStyleSettingApi.class);
        Activity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        iLebaUIStyleSettingApi.openStyleSetting((QBaseActivity) activity);
    }

    @Override // com.qzone.reborn.feedx.part.QZoneFriendFeedTitlePart
    public void S9() {
        super.S9();
        if (com.qzone.util.ah.b()) {
            aa();
        }
    }

    @Override // com.qzone.reborn.feedx.part.QZoneFriendFeedTitlePart
    public boolean T9() {
        return false;
    }

    @Override // com.qzone.reborn.feedx.part.QZoneFriendFeedTitlePart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxOldFrameTitlePart";
    }

    @Override // com.qzone.reborn.feedx.part.QZoneFriendFeedTitlePart, com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        L9().u();
        L9().setProgressBarEnable(true);
        boolean i3 = MainResourceConfig.INSTANCE.i();
        QLog.i(getTAG(), 1, "onInitView  isUIFor9000:" + i3);
        if (i3) {
            L9().getMLeftTitle().setVisibility(0);
            L9().getMTitleName().setVisibility(8);
            L9().getMLeftTitle().setText(com.qzone.util.l.a(R.string.mvs));
        } else {
            L9().getMLeftTitle().setVisibility(8);
            L9().getMTitleName().setVisibility(0);
            L9().getMTitleName().setText(com.qzone.util.l.a(R.string.mvs));
        }
    }

    public aq() {
        super(false);
    }
}
