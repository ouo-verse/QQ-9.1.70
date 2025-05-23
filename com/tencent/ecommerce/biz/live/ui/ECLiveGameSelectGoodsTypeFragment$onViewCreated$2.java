package com.tencent.ecommerce.biz.live.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ecommerce.base.ECHandleSchemeResult;
import com.tencent.ecommerce.base.router.api.IECLogicCallback;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
/* loaded from: classes31.dex */
final class ECLiveGameSelectGoodsTypeFragment$onViewCreated$2 implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ECLiveGameSelectGoodsTypeFragment f102680d;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bH\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/live/ui/ECLiveGameSelectGoodsTypeFragment$onViewCreated$2$1", "Lcom/tencent/ecommerce/base/router/api/IECLogicCallback;", "onResult", "", "result", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.live.ui.ECLiveGameSelectGoodsTypeFragment$onViewCreated$2$1, reason: invalid class name */
    /* loaded from: classes31.dex */
    public static final class AnonymousClass1 implements IECLogicCallback {
        AnonymousClass1() {
        }

        @Override // com.tencent.ecommerce.base.router.api.IECLogicCallback
        public void onResult(final HashMap<String, Object> result) {
            ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.ECLiveGameSelectGoodsTypeFragment$onViewCreated$2$1$onResult$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Object obj = result.get("PARAM_JSON_RESULT");
                    if (obj != null) {
                        JSONObject jSONObject = (JSONObject) obj;
                        if (jSONObject.has("live_product_counts")) {
                            ECLiveGameSelectGoodsTypeFragment$onViewCreated$2.this.f102680d.goodsNumber = jSONObject.optInt("live_product_counts", 0);
                            ECLiveGameSelectGoodsTypeFragment eCLiveGameSelectGoodsTypeFragment = ECLiveGameSelectGoodsTypeFragment$onViewCreated$2.this.f102680d;
                            eCLiveGameSelectGoodsTypeFragment.ai(eCLiveGameSelectGoodsTypeFragment.goodsNumber > 0);
                            if (ECLiveGameSelectGoodsTypeFragment$onViewCreated$2.this.f102680d.goodsNumber > 0) {
                                ECLiveGameSelectGoodsTypeFragment.Sh(ECLiveGameSelectGoodsTypeFragment$onViewCreated$2.this.f102680d).setText("\u5df2\u6dfb\u52a0" + ECLiveGameSelectGoodsTypeFragment$onViewCreated$2.this.f102680d.goodsNumber + "\u4e2a\u5546\u54c1");
                            } else {
                                ECLiveGameSelectGoodsTypeFragment.Sh(ECLiveGameSelectGoodsTypeFragment$onViewCreated$2.this.f102680d).setText(ECLiveGameSelectGoodsTypeFragment$onViewCreated$2.this.f102680d.requireContext().getString(R.string.wnf));
                            }
                        } else if (jSONObject.has(ECHandleSchemeResult.SCHEME_RESULT_ERROR.toString())) {
                            i.f101155b.d(ECLiveGameSelectGoodsTypeFragment$onViewCreated$2.this.f102680d.requireContext().getString(R.string.wlb), ECToastIcon.ICON_ERROR, 0);
                        }
                        cg0.a.b("ECLiveSelectGoodsTypeFloatFragment", "LIVE_SCHEME_TYPE_ENTRY onCallbackFinished, jsonObject: " + jSONObject);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECLiveGameSelectGoodsTypeFragment$onViewCreated$2(ECLiveGameSelectGoodsTypeFragment eCLiveGameSelectGoodsTypeFragment) {
        this.f102680d = eCLiveGameSelectGoodsTypeFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        String str2;
        EventCollector.getInstance().onViewClickedBefore(view);
        FragmentActivity activity = this.f102680d.getActivity();
        Intent intent = activity != null ? activity.getIntent() : null;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("PARAM_ROOM_ID", this.f102680d.roomId);
        hashMap.put("PARAM_USER_ID", this.f102680d.userId);
        str = this.f102680d.sessionId;
        if (!TextUtils.isEmpty(str)) {
            str2 = this.f102680d.sessionId;
            hashMap.put("PARAM_SESSION_ID", str2);
        }
        if (intent != null && intent.hasExtra("entryJumpScheme")) {
            String stringExtra = intent.getStringExtra("entryJumpScheme");
            if (stringExtra == null) {
                stringExtra = "";
            }
            hashMap.put("PARAM_ENTRY_JUMP_SCHEME", stringExtra);
            cg0.a.b("ECLiveSelectGoodsTypeFloatFragment", "ACTION_CLICK_LIVE_ENTRY onCall map has add scheme:" + stringExtra);
        }
        com.tencent.ecommerce.biz.live.a.f102661d.m(hashMap, new AnonymousClass1());
        ei0.a.f396300a.c(ECLiveGameSelectGoodsTypeFragment.Qh(this.f102680d), "em_qqlive_wz_shop_button", this.f102680d.roomId, this.f102680d.userId);
        EventCollector.getInstance().onViewClicked(view);
    }
}
