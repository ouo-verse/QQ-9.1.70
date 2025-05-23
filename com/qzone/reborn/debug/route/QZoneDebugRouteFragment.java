package com.qzone.reborn.debug.route;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.debug.route.QZoneDebugRouteFragment;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import ef.d;
import ho.i;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J \u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u001a\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/qzone/reborn/debug/route/QZoneDebugRouteFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "initView", "sh", "Landroid/content/Context;", "context", "", "pageName", "routeUrl", "Landroid/widget/FrameLayout;", "qh", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "mTitle", "", "D", "Ljava/util/Map;", "mRouteMap", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneDebugRouteFragment extends QZoneBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView mTitle;

    /* renamed from: D, reason: from kotlin metadata */
    private Map<String, String> mRouteMap = new LinkedHashMap();

    private final FrameLayout qh(final Context context, String pageName, final String routeUrl) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, d.b(48)));
        frameLayout.setPadding(d.b(20), 0, d.b(20), 0);
        TextView textView = new TextView(context);
        textView.setTextSize(18.0f);
        textView.setText(pageName);
        textView.setTextColor(context.getColor(R.color.qui_common_text_primary));
        textView.setGravity(16);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 8388611;
        frameLayout.addView(textView, layoutParams);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: jd.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneDebugRouteFragment.rh(context, routeUrl, view);
            }
        });
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rh(Context context, String routeUrl, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(routeUrl, "$routeUrl");
        i.q(context, routeUrl);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f129596h;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FragmentActivity activity = getActivity();
        ImmersiveUtils.setStatusTextColor(true, activity != null ? activity.getWindow() : null);
        initView(view);
    }

    private final void sh() {
        Map<String, String> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("AI\u6d88\u9664\u5927\u5c3e\u5df4", QQWinkConstants.QZONE_SHARE_VALUE_ELIMINATE_SCHEMA), TuplesKt.to("\u7167\u7247\u4fee\u590d\u9996\u9875", "mqzone://arouse/photorepair/mainpage"), TuplesKt.to("\u76f8\u518c\u9080\u8bf7\u9875", "mqzone://arouse/invitemiddlepage?albumid=V52UtE9B475hhj1Ik0xa1G57Xl42lXiS&owner=2830116175"), TuplesKt.to("\u76f8\u518c\u7533\u8bf7\u9875", "mqzone://arouse/applymiddlepage?albumid=V52UtE9B475hhj1Ik0xa1G57Xl42lXiS&owner=2830116175"), TuplesKt.to("\u76f8\u518c\u8be6\u60c5\u9875", "mqzone://arouse/album?source=doNotJumpQzone&albumid=V52M2ir23pOqbn2dddEW4CNXcX4MEt0i&uin=610740026&albumrights=3&question=&version=1&individualalbum=0&albumtype=0&clicktime=1730812554045"), TuplesKt.to("\u4e2a\u4eba\u4e3b\u9875", "mqzone://arouse/homepage?uin=3587745282&from_uin=" + LoginData.getInstance().getUinString()), TuplesKt.to("\u4e2a\u4eba\u4e3b\u9875http", "https://mp.qzone.qq.com/u/3587745282?uin=3587745282&is_famous_space=0&brand_flag=0&from_uin=" + LoginData.getInstance().getUinString()), TuplesKt.to("57\u4f4d\u8ba4\u8bc1\u7a7a\u95f4", "https://mp.qzone.qq.com/u/88882222?uin=88882222&is_famous_space=1&brand_flag=1"), TuplesKt.to("52\u4f4d\u8ba4\u8bc1\u7a7a\u95f4", "https://mp.qzone.qq.com/u/88882222?uin=1650000714&is_famous_space=1&brand_flag=1"), TuplesKt.to("\u6821\u56ed\u53f7", "https://mp.qzone.qq.com/u/88882222?uin=2646919700&is_famous_space=1&brand_flag=1"), TuplesKt.to("\u660e\u661f\u53f7", "https://mp.qzone.qq.com/u/88882222?uin=2300001249&is_famous_space=1&brand_flag=1"), TuplesKt.to("\u53ef\u88ab\u5173\u6ce8\u7684ugc\u53f7\u7801(\u8fbe\u4eba\uff09", "https://mp.qzone.qq.com/u/2300001271?uin=2300001249&is_famous_space=1&brand_flag=1"), TuplesKt.to("\u88ab\u52a8\u6d88\u606fpush", "mqzone://arouse/passivityfeed?source=push&version=1&pushtype=1"), TuplesKt.to("\u7279\u522b\u5173\u5fc3push", "mqzone://arouse/specialfriend?source=push&uid=ed9845a14da5de65a36b0100&bid=&uin=2705692909&appid=311&subid=0&photonum=0&version=1&pushtype=2"), TuplesKt.to("\u76f8\u518c\u5217\u8868\u9875", "mqzone://arouse/albumlist"), TuplesKt.to("\u8be6\u60c5\u9875scheme", "mqzone://arouse/detail?appid=4&uin=453714648&cellid=5fa3a518-d906-4e1d-8f21-6dd92dc7788f&bid=NR8AVjZiQ1FBME5UTTNNVFEyTkRobDhKUm1pNipBTlEhIQoAcGhvdG9nem1heg!!&loginfrom=52&photonum=1"), TuplesKt.to("\u8be6\u60c5\u9875scheme_\u65e0num", "mqzone://arouse/detail?appid=4&uin=453714648&cellid=5fa3a518-d906-4e1d-8f21-6dd92dc7788f&bid=NR8AVjZiQ1FBME5UTTNNVFEyTkRobDhKUm1pNipBTlEhIQoAcGhvdG9nem1heg!!&loginfrom=52"), TuplesKt.to("\u8be6\u60c5\u9875scheme_num2", "mqzone://arouse/detail?appid=4&uin=453714648&cellid=5fa3a518-d906-4e1d-8f21-6dd92dc7788f&bid=NR8AVjZiQ1FBME5UTTNNVFEyTkRobDhKUm1pNipBTlEhIQoAcGhvdG9nem1heg!!&loginfrom=52&photonum=2"), TuplesKt.to("\u8be6\u60c5\u9875scheme_subid", "mqzone://arouse/detail?appid=4&uin=453714648&cellid=5fa3a518-d906-4e1d-8f21-6dd92dc7788f&subid=NR8AVjZiQ1FBME5UTTNNVFEyTkRobDhKUm1pNipBTlEhIQoAcGhvdG9nem1heg!!&bid=NR8AVjZiQ1FBME5UTTNNVFEyTkRobDhKUm1pNipBTlEhIQoAcGhvdG9nem1heg!!&loginfrom=52"), TuplesKt.to("\u8be6\u60c5\u9875\u8c46\u8150\u5757", "mqzone://arouse/detail?appid=311&uin=2978968370&cellid=32738fb1d0384567d8f50400&loginfrom=3"));
        this.mRouteMap = mutableMapOf;
    }

    private final void initView(View rootView) {
        View findViewById = rootView.findViewById(R.id.mtn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qzone_debug_root_view)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        TextView textView = (TextView) rootView.findViewById(R.id.mtu);
        this.mTitle = textView;
        if (textView != null) {
            textView.setText(getString(R.string.jmf));
        }
        sh();
        Map<String, String> map = this.mRouteMap;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                FragmentActivity it = getActivity();
                if (it != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    linearLayout.addView(qh(it, key, value));
                }
            }
        }
    }
}
