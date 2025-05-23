package com.tencent.biz.qqcircle.immersive.datacardcover.widget;

import android.content.Context;
import android.view.View;
import com.tencent.biz.qqcircle.immersive.datacardcover.fragment.QFSPersonalCoverFeedFragment;
import com.tencent.biz.qqcircle.immersive.datacardcover.widget.QFSPersonalCoverPlusItemView;
import com.tencent.biz.qqcircle.immersive.redpacket.util.d;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import h40.QFSPersonalCoverFeedInfo;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB7\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012&\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0011\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\b\u001a\u00020\u00072\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0014J\b\u0010\u000f\u001a\u00020\u0005H\u0014R7\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverPlusItemView;", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverBaseItemView;", "", "o0", "", "", "schemeAttrs", "", "n0", "", "getLayoutId", "Lh40/a;", "coverFeedInfo", c.G, "l0", "getLogTag", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "getMap", "()Ljava/util/HashMap;", "map", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/util/HashMap;)V", "e", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPersonalCoverPlusItemView extends QFSPersonalCoverBaseItemView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final HashMap<String, String> map;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSPersonalCoverPlusItemView(@NotNull Context context, @Nullable HashMap<String, String> hashMap) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.map = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(QFSPersonalCoverPlusItemView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean n0(Map<String, String> schemeAttrs) {
        Object obj;
        if (schemeAttrs == null) {
            QLog.d("QFSPersonalCoverPlusItemView", 1, "isFromMakeRedPacket, schemeAttrs is null ");
            return false;
        }
        try {
            String str = schemeAttrs.get(QCircleScheme.AttrQQPublish.IS_FROM_RED_ENVELOPE);
            if (str != null) {
                obj = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
            } else {
                obj = null;
            }
        } catch (Exception e16) {
            QLog.w("QFSPersonalCoverPlusItemView", 1, "isFromMakeRedPacket, error ", e16);
            obj = Unit.INSTANCE;
        }
        return Intrinsics.areEqual(obj, (Object) 1);
    }

    private final void o0() {
        if (n0(this.map)) {
            d dVar = d.f89585a;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            HashMap<String, String> hashMap = this.map;
            if (hashMap != null) {
                hashMap.put("taskid", "qqhongbao-1");
                Unit unit = Unit.INSTANCE;
            } else {
                hashMap = null;
            }
            d.g(dVar, context, null, hashMap, 2, null);
            return;
        }
        i40.c cVar = i40.c.f407182a;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        cVar.b(context2, QFSPersonalCoverFeedFragment.INSTANCE.a(this.map));
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gkv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    @NotNull
    public String getLogTag() {
        return "QFSPersonalCoverPlusItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void bindData(@NotNull QFSPersonalCoverFeedInfo coverFeedInfo, int pos) {
        Intrinsics.checkNotNullParameter(coverFeedInfo, "coverFeedInfo");
        setOnClickListener(new View.OnClickListener() { // from class: k40.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPersonalCoverPlusItemView.m0(QFSPersonalCoverPlusItemView.this, view);
            }
        });
    }
}
