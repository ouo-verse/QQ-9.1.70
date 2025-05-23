package com.tencent.timi.game.expand.hall.impl.operation;

import af4.OperationItem;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.luggage.wxa.xd.l0;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.timi.game.ad.ui.BaseOperationContainer;
import com.tencent.timi.game.ad.ui.OperationItemView;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView;
import com.tencent.timi.game.utils.j;
import com.tencent.timi.game.utils.l;
import gh4.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.MessageOuterClass$MsgContent;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 02\u00020\u0001:\u00011B'\b\u0007\u0012\u0006\u0010*\u001a\u00020)\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+\u0012\b\b\u0002\u0010-\u001a\u00020\u0007\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u000f\u001a\u00020\u0007H\u0014J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0014J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H\u0014J\b\u0010\u0014\u001a\u00020\u0007H\u0014J\b\u0010\u0015\u001a\u00020\u0002H\u0014J\u0014\u0010\u0018\u001a\u00020\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0010R$\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0019j\b\u0012\u0004\u0012\u00020\u0007`\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR$\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0019j\b\u0012\u0004\u0012\u00020\u0011`\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0018\u0010\"\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0017\u0010(\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\u00a8\u00062"}, d2 = {"Lcom/tencent/timi/game/expand/hall/impl/operation/HallOperationContainer;", "Lcom/tencent/timi/game/ad/ui/BaseOperationContainer;", "", "D", "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "sourceId", "B", "Lgh4/e;", "hall", BdhLogUtil.LogTag.Tag_Conn, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "", "Lcom/tencent/mobileqq/tianshu/data/TianShuAdPosItemData;", "o", DomainData.DOMAIN_NAME, ReportConstant.COSTREPORT_PREFIX, "u", "", "indicatorColors", "setIndicatorColors", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "M", "Ljava/util/ArrayList;", "mHallOperationAdIds", "N", "mHallOperationAdPosList", "P", "Lgh4/e;", "mHall", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView$b;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView$b;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView$b;", "inputStateListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Req, "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class HallOperationContainer extends BaseOperationContainer {

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<Integer> mHallOperationAdIds;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<TianShuAdPosItemData> mHallOperationAdPosList;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private e mHall;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final TimiBaseInputView.b inputStateListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/timi/game/expand/hall/impl/operation/HallOperationContainer$b", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView$b;", "", "text", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "content", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", "timiBaseInputView", "", "a", "b", "", "state", "onStateChanged", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements TimiBaseInputView.b {
        b() {
        }

        @Override // com.tencent.timi.game.component.chat.input.TimiBaseInputView.b
        public void a(@NotNull String text, @NotNull MessageOuterClass$MsgContent content, @NotNull TimiBaseInputView timiBaseInputView) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(timiBaseInputView, "timiBaseInputView");
        }

        @Override // com.tencent.timi.game.component.chat.input.TimiBaseInputView.b
        public void b(@NotNull String text, @NotNull TimiBaseInputView timiBaseInputView) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(timiBaseInputView, "timiBaseInputView");
        }

        @Override // com.tencent.timi.game.component.chat.input.TimiBaseInputView.b
        public void onStateChanged(int state) {
            if (state == 1) {
                HallOperationContainer.this.setVisibility(0);
            } else {
                HallOperationContainer.this.setVisibility(8);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/timi/game/expand/hall/impl/operation/HallOperationContainer$c", "Lcom/tencent/timi/game/ad/ui/OperationItemView$c;", "", "b", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements OperationItemView.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f376938a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f376939b;

        c(int i3, int i16) {
            this.f376938a = i3;
            this.f376939b = i16;
        }

        @Override // com.tencent.timi.game.ad.ui.OperationItemView.c
        /* renamed from: a, reason: from getter */
        public int getF376939b() {
            return this.f376939b;
        }

        @Override // com.tencent.timi.game.ad.ui.OperationItemView.c
        /* renamed from: b, reason: from getter */
        public int getF376938a() {
            return this.f376938a;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/timi/game/expand/hall/impl/operation/HallOperationContainer$d", "Lcom/tencent/timi/game/ad/ui/OperationItemView$b;", "Laf4/d;", "itemData", "", "a", "", "b", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements OperationItemView.b {
        d() {
        }

        @Override // com.tencent.timi.game.ad.ui.OperationItemView.b
        public void a(@NotNull OperationItem itemData) {
            boolean z16;
            Uri uri;
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            l.i("BaseOperationContainer_", "beforeJump " + itemData);
            if (itemData.getJumpUrl().length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return;
            }
            try {
                uri = Uri.parse(itemData.getJumpUrl());
            } catch (Exception unused) {
                uri = null;
            }
            if (uri != null) {
                String uri2 = HallOperationContainer.this.z(uri).toString();
                Intrinsics.checkNotNullExpressionValue(uri2, "newUri.toString()");
                itemData.K(uri2);
            }
        }

        @Override // com.tencent.timi.game.ad.ui.OperationItemView.b
        public boolean b(@NotNull OperationItem itemData) {
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            return false;
        }

        @Override // com.tencent.timi.game.ad.ui.OperationItemView.b
        public void c(@NotNull OperationItem itemData) {
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            l.i("BaseOperationContainer_", "afterJump " + itemData);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HallOperationContainer(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void B(int sourceId) {
        this.mHallOperationAdIds.clear();
        this.mHallOperationAdPosList.clear();
        if (sourceId != 1) {
            if (sourceId != 2) {
                if (sourceId == 3) {
                    this.mHallOperationAdIds.add(928);
                }
            } else {
                this.mHallOperationAdIds.add(925);
            }
        } else {
            this.mHallOperationAdIds.add(Integer.valueOf(l0.CTRL_INDEX));
        }
        Iterator<Integer> it = this.mHallOperationAdIds.iterator();
        while (it.hasNext()) {
            Integer id5 = it.next();
            TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
            Intrinsics.checkNotNullExpressionValue(id5, "id");
            tianShuAdPosItemData.mPosId = id5.intValue();
            tianShuAdPosItemData.mNeedCnt = 3;
            this.mHallOperationAdPosList.add(tianShuAdPosItemData);
        }
        l.i("BaseOperationContainer_", "initAdIds sourceId:" + sourceId + ", mHallOperationAdIds:" + this.mHallOperationAdIds);
    }

    private final void D() {
        setJumpInterceptor(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Uri z(Uri uri) {
        String str;
        String num;
        HashSet hashSet = new HashSet();
        hashSet.add("roomId");
        hashSet.add("yesGameId");
        HashMap hashMap = new HashMap();
        e eVar = this.mHall;
        String str2 = "";
        if (eVar == null || (str = Long.valueOf(eVar.ue()).toString()) == null) {
            str = "";
        }
        hashMap.put("roomId", str);
        e eVar2 = this.mHall;
        if (eVar2 != null && (num = Integer.valueOf(eVar2.o1()).toString()) != null) {
            str2 = num;
        }
        hashMap.put("yesGameId", str2);
        Uri newUri = j.a(j.b(uri, hashSet), hashMap);
        Intrinsics.checkNotNullExpressionValue(newUri, "newUri");
        return newUri;
    }

    @NotNull
    /* renamed from: A, reason: from getter */
    public final TimiBaseInputView.b getInputStateListener() {
        return this.inputStateListener;
    }

    public final void C(@NotNull e hall) {
        Intrinsics.checkNotNullParameter(hall, "hall");
        this.mHall = hall;
        D();
        B(hall.O().f376301d);
        l();
    }

    @Override // com.tencent.timi.game.ad.ui.BaseOperationContainer
    @NotNull
    protected List<Integer> n() {
        return this.mHallOperationAdIds;
    }

    @Override // com.tencent.timi.game.ad.ui.BaseOperationContainer
    @NotNull
    protected List<TianShuAdPosItemData> o() {
        return this.mHallOperationAdPosList;
    }

    @Override // com.tencent.timi.game.ad.ui.BaseOperationContainer
    protected int p() {
        return -1;
    }

    @Override // com.tencent.timi.game.ad.ui.BaseOperationContainer
    protected long q() {
        e eVar = this.mHall;
        if (eVar != null) {
            return eVar.ue();
        }
        return 0L;
    }

    @Override // com.tencent.timi.game.ad.ui.BaseOperationContainer
    protected int s() {
        return 2;
    }

    public final void setIndicatorColors(@NotNull List<String> indicatorColors) {
        Intrinsics.checkNotNullParameter(indicatorColors, "indicatorColors");
        l.i("BaseOperationContainer_", "setIndicatorColors " + indicatorColors);
        if (indicatorColors.size() < 2) {
            return;
        }
        setSkinCallback(new c(fh4.c.a(indicatorColors.get(0)), fh4.c.a(indicatorColors.get(1))));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.ad.ui.BaseOperationContainer
    public void u() {
        super.u();
        if (r().size() > 0) {
            t();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HallOperationContainer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ HallOperationContainer(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HallOperationContainer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mHallOperationAdIds = new ArrayList<>();
        this.mHallOperationAdPosList = new ArrayList<>();
        this.inputStateListener = new b();
    }
}
