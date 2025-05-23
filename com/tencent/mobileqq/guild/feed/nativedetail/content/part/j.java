package com.tencent.mobileqq.guild.feed.nativedetail.content.part;

import android.app.Activity;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import jl1.CommentRankingTypeData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl1.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016R\u0016\u0010\u001a\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/j;", "Lcom/tencent/biz/richframework/part/Part;", "Lvl1/b;", "", "args", "", "x9", "initData", "z9", "", "count", "", "needUpdate", "A9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "", "action", "handleBroadcastMessage", "y0", "d", "Ljava/lang/String;", "feedId", "e", "I", "rankingType", "Ljl1/e;", "f", "Ljl1/e;", "rankingTypeData", "<init>", "()V", tl.h.F, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class j extends Part implements vl1.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String feedId = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int rankingType = 1;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CommentRankingTypeData rankingTypeData;

    private final void A9(int count, boolean needUpdate) {
        a.ModifyBottomInteractiveDataMessage modifyBottomInteractiveDataMessage = new a.ModifyBottomInteractiveDataMessage(null, needUpdate, null, null, null, null, 61, null);
        modifyBottomInteractiveDataMessage.g(Integer.valueOf(count));
        Unit unit = Unit.INSTANCE;
        broadcastMessage("message_modify_bottom_interact_data", modifyBottomInteractiveDataMessage);
    }

    private final void initData() {
        String string = GuildSplitViewUtils.f235370a.h(getPartHost()).getString("feed_id", "");
        Intrinsics.checkNotNullExpressionValue(string, "getString(NativeDetailConstants.FEED_ID, \"\")");
        this.feedId = string;
    }

    private final void x9(Object args) {
        jl1.f fVar;
        Object obj;
        if (!(args instanceof g.OnDataListChangedMessage)) {
            return;
        }
        g.OnDataListChangedMessage onDataListChangedMessage = (g.OnDataListChangedMessage) args;
        if (onDataListChangedMessage.getChangedSource() == 6 || onDataListChangedMessage.getChangedSource() == 10 || onDataListChangedMessage.getChangedSource() == 13) {
            Iterator<T> it = onDataListChangedMessage.b().iterator();
            while (true) {
                fVar = null;
                if (it.hasNext()) {
                    obj = it.next();
                    if (((hl1.g) obj) instanceof jl1.f) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            hl1.g gVar = (hl1.g) obj;
            if (gVar instanceof jl1.f) {
                fVar = (jl1.f) gVar;
            }
            if (fVar != null) {
                boolean z16 = true;
                QLog.d("CommentTitlePart", 1, "updateCommentCount " + fVar.getTotalNum());
                int totalNum = fVar.getTotalNum();
                if (onDataListChangedMessage.getChangedSource() == 13) {
                    z16 = false;
                }
                A9(totalNum, z16);
            }
        }
    }

    private final void z9() {
        this.rankingTypeData = new CommentRankingTypeData(this.feedId, this.rankingType);
        jj1.b.c().initOrUpdateGlobalState((jj1.b) this.rankingTypeData, true);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "message_data_list_changed")) {
            x9(args);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        initData();
        z9();
        RFWIocAbilityProvider.g().registerIoc(rootView, this, vl1.b.class);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        RFWIocAbilityProvider.g().unregisterSingleIoc(getPartRootView(), vl1.b.class);
    }

    @Override // vl1.b
    /* renamed from: y0, reason: from getter */
    public int getRankingType() {
        return this.rankingType;
    }
}
