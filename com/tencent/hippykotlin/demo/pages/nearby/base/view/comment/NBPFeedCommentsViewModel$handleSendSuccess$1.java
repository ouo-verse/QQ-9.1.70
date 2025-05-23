package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment;

import com.tencent.kuikly.core.reactive.collection.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import p35.ae;
import p35.h;
import p35.i;
import s35.af;

/* loaded from: classes31.dex */
public final class NBPFeedCommentsViewModel$handleSendSuccess$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ NBPCommentVO $addOrUpdateComment;
    public final /* synthetic */ NBPReplyVO $addReply;
    public final /* synthetic */ String $id;
    public final /* synthetic */ NBPFeedCommentsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NBPFeedCommentsViewModel$handleSendSuccess$1(NBPReplyVO nBPReplyVO, NBPCommentVO nBPCommentVO, String str, NBPFeedCommentsViewModel nBPFeedCommentsViewModel) {
        super(0);
        this.$addReply = nBPReplyVO;
        this.$addOrUpdateComment = nBPCommentVO;
        this.$id = str;
        this.this$0 = nBPFeedCommentsViewModel;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPReplyVO>, java.util.ArrayList] */
    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        int collectionSizeOrDefault;
        List plus;
        List mutableList;
        NBPCommentVO nBPCommentVO;
        NBPReplyVO nBPReplyVO = this.$addReply;
        if (nBPReplyVO == null) {
            NBPCommentVO nBPCommentVO2 = this.$addOrUpdateComment;
            nBPCommentVO = new NBPCommentVO(new h(nBPCommentVO2.user, nBPCommentVO2.cTime, this.$id, nBPCommentVO2.content, nBPCommentVO2.respNum, nBPCommentVO2.raw.f425178m, 64), this.this$0.data.posterUserId, true);
        } else {
            ae aeVar = new ae(nBPReplyVO.user, nBPReplyVO.cTime, this.$id, nBPReplyVO.content, nBPReplyVO.targetUser, 16);
            NBPCommentVO nBPCommentVO3 = this.$addOrUpdateComment;
            af afVar = nBPCommentVO3.user;
            int i3 = nBPCommentVO3.cTime;
            String str = nBPCommentVO3.f114212id;
            i iVar = nBPCommentVO3.content;
            int i16 = nBPCommentVO3.respNum + 1;
            ?? r06 = nBPCommentVO3.replies;
            ArrayList arrayList = new ArrayList();
            Iterator it = r06.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (((NBPReplyVO) next).submitted) {
                    arrayList.add(next);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                arrayList2.add(((NBPReplyVO) it5.next()).raw);
            }
            plus = CollectionsKt___CollectionsKt.plus((Collection<? extends ae>) ((Collection<? extends Object>) arrayList2), aeVar);
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) plus);
            nBPCommentVO = new NBPCommentVO(new h(afVar, i3, str, iVar, i16, mutableList, 64), this.this$0.data.posterUserId, this.$addOrUpdateComment.getRepliesFold());
        }
        c<NBPCommentVO> commentItems = this.this$0.getCommentItems();
        NBPCommentVO nBPCommentVO4 = this.$addOrUpdateComment;
        Iterator<NBPCommentVO> it6 = commentItems.iterator();
        int i17 = 0;
        while (true) {
            if (!it6.hasNext()) {
                i17 = -1;
                break;
            }
            if (it6.next().key == nBPCommentVO4.key) {
                break;
            }
            i17++;
        }
        if (i17 >= 0) {
            this.this$0.getCommentItems().set(i17, nBPCommentVO);
        }
        return Unit.INSTANCE;
    }
}
