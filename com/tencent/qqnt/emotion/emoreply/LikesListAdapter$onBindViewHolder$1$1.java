package com.tencent.qqnt.emotion.emoreply;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.emotion.emoreply.LikesListAdapter;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "nickInfo", "Lcom/tencent/mobileqq/data/troop/TroopMemberNickInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
final class LikesListAdapter$onBindViewHolder$1$1 extends Lambda implements Function1<TroopMemberNickInfo, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ com.tencent.qqnt.aio.emoreply.f $detailData;
    final /* synthetic */ j $likesData;
    final /* synthetic */ RecyclerView.ViewHolder $viewHolder;
    final /* synthetic */ LikesListAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LikesListAdapter$onBindViewHolder$1$1(RecyclerView.ViewHolder viewHolder, LikesListAdapter likesListAdapter, j jVar, com.tencent.qqnt.aio.emoreply.f fVar) {
        super(1);
        this.$viewHolder = viewHolder;
        this.this$0 = likesListAdapter;
        this.$likesData = jVar;
        this.$detailData = fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, viewHolder, likesListAdapter, jVar, fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(com.tencent.qqnt.aio.emoreply.f detailData, LikesListAdapter this$0, j likesData, View view) {
        int i3;
        long j3;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(detailData, "$detailData");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(likesData, "$likesData");
        Integer a16 = h.a(detailData);
        if (a16 != null) {
            i3 = a16.intValue();
        } else {
            i3 = -1;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("click_pos", "2");
        j3 = this$0.com.tencent.mobileqq.app.AppConstants.Key.COLUMN_MSG_SENDER_UIN java.lang.String;
        hashMap.put("touin", String.valueOf(j3));
        hashMap.put("reply_uin", String.valueOf(likesData.b()));
        hashMap.put(QzoneCameraConst.Tag.ARG_PARAM_STICKER_ID, String.valueOf(i3));
        com.tencent.mobileqq.aio.utils.b.l("em_bas_emoticon_response_details_panel", hashMap);
        this$0.o0(String.valueOf(likesData.b()));
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TroopMemberNickInfo troopMemberNickInfo) {
        invoke2(troopMemberNickInfo);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable TroopMemberNickInfo troopMemberNickInfo) {
        String l06;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopMemberNickInfo);
            return;
        }
        TextView o16 = ((LikesListAdapter.c) this.$viewHolder).o();
        l06 = this.this$0.l0(troopMemberNickInfo != null ? troopMemberNickInfo.getShowName() : null, this.$likesData.a());
        o16.setText(l06);
        LinearLayout m3 = ((LikesListAdapter.c) this.$viewHolder).m();
        final com.tencent.qqnt.aio.emoreply.f fVar = this.$detailData;
        final LikesListAdapter likesListAdapter = this.this$0;
        final j jVar = this.$likesData;
        m3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.emotion.emoreply.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LikesListAdapter$onBindViewHolder$1$1.b(com.tencent.qqnt.aio.emoreply.f.this, likesListAdapter, jVar, view);
            }
        });
    }
}
