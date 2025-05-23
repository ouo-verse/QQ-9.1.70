package com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate;

import NS_MINI_APP_MISC.MISC$StGetFriendPlayListV2Rsp;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.biz.richframework.part.adapter.section.SectionViewHolder;
import com.tencent.mobileqq.friends.intimate.IntimatePlayTogetherMiniGameCardView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import j61.IntimateBaseModel;
import java.util.ArrayList;
import java.util.List;
import k61.r;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$CommonBody;
import tencent.im.oidb.oidb_0xd84$RspBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0014\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\t\u001a\u00020\bH\u0014J4\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u001a\u0010\u0011\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u00100\u000f0\u000eH\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/reborn/itemdelegate/n;", "Lcom/tencent/mobileqq/activity/aio/intimate/reborn/itemdelegate/h;", "Lj61/a;", "model", "", "b", "", "getLayoutId", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/biz/richframework/part/adapter/section/SectionViewHolder;", "onCreateViewHolder", "Landroid/view/View;", "itemView", "", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "sections", "", "initSection", "<init>", "()V", "d", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class n extends h {
    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.h
    public boolean b(@NotNull IntimateBaseModel model) {
        boolean z16;
        Intrinsics.checkNotNullParameter(model, "model");
        List<oidb_0xcf4$CommonBody> list = model.getIntimateInfo().commonBodies;
        List<oidb_0xcf4$CommonBody> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        oidb_0xcf4$CommonBody oidb_0xcf4_commonbody = null;
        for (oidb_0xcf4$CommonBody oidb_0xcf4_commonbody2 : list) {
            if (oidb_0xcf4_commonbody2.uint32_oidb_cmd.get() == 3460) {
                oidb_0xcf4_commonbody = oidb_0xcf4_commonbody2;
            }
        }
        if (oidb_0xcf4_commonbody == null) {
            return false;
        }
        try {
            oidb_0xd84$RspBody oidb_0xd84_rspbody = new oidb_0xd84$RspBody();
            oidb_0xd84_rspbody.mergeFrom(oidb_0xcf4_commonbody.string_oidb_body.get().toByteArray());
            new MISC$StGetFriendPlayListV2Rsp().mergeFrom(oidb_0xd84_rspbody.bytes_xmitinfo.get().toByteArray());
            return !r0.appPlayingInfos.isEmpty();
        } catch (Exception e16) {
            QLog.e("IntimatePlayTogetherMiniGameItemDelegate", 1, "parse error:", e16);
            return false;
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(@NotNull ViewGroup parent, @NotNull View itemView, @NotNull List<Class<? extends Section<IntimateBaseModel>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        sections.add(r.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.h, com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NotNull
    public SectionViewHolder<?> onCreateViewHolder(@NotNull ViewGroup parent) {
        Context context;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (!(parent.getContext() instanceof Activity) && (parent.getContext() instanceof ContextWrapper)) {
            Context context2 = parent.getContext();
            Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.content.ContextWrapper");
            context = ((ContextWrapper) context2).getBaseContext();
        } else {
            context = parent.getContext();
        }
        IntimatePlayTogetherMiniGameCardView intimatePlayTogetherMiniGameCardView = new IntimatePlayTogetherMiniGameCardView(context);
        intimatePlayTogetherMiniGameCardView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        ArrayList arrayList = new ArrayList();
        initSection(parent, intimatePlayTogetherMiniGameCardView, arrayList);
        return new SectionViewHolder<>(intimatePlayTogetherMiniGameCardView, arrayList);
    }
}
