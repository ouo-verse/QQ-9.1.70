package oh;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.reborn.base.i;
import com.qzone.reborn.feedx.widget.comment.QZoneFeedBaseCommentWidget;
import com.qzone.reborn.feedx.widget.comment.QZoneFeedCommentWidget;
import com.qzone.reborn.feedx.widget.comment.QZoneFeedReplyWidget;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.utils.bl;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends i<C10911a> {
    private ArrayList<b> C;
    private BusinessFeedData D;
    private int E = 0;
    private int F = Integer.MAX_VALUE;
    private int G;
    private int H;

    /* renamed from: m, reason: collision with root package name */
    private final int f422672m;

    /* compiled from: P */
    /* renamed from: oh.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static class C10911a extends RecyclerView.ViewHolder {
        private final QZoneFeedBaseCommentWidget E;

        public C10911a(QZoneFeedBaseCommentWidget qZoneFeedBaseCommentWidget) {
            super(qZoneFeedBaseCommentWidget);
            this.E = qZoneFeedBaseCommentWidget;
        }

        public void l(BusinessFeedData businessFeedData, b bVar, int i3, int i16) {
            this.E.setFeedData(businessFeedData);
            this.E.setFeedPosition(i16);
            QZoneFeedBaseCommentWidget qZoneFeedBaseCommentWidget = this.E;
            if (qZoneFeedBaseCommentWidget instanceof QZoneFeedCommentWidget) {
                qZoneFeedBaseCommentWidget.setData(bVar, i3);
            } else if (qZoneFeedBaseCommentWidget instanceof QZoneFeedReplyWidget) {
                qZoneFeedBaseCommentWidget.setData(bVar, i3);
            }
        }
    }

    public a(int i3) {
        this.f422672m = i3;
    }

    private ArrayList<b> i0(BusinessFeedData businessFeedData) {
        ArrayList<b> arrayList = new ArrayList<>();
        if (p0(businessFeedData)) {
            return arrayList;
        }
        ArrayList<Comment> arrayList2 = businessFeedData.getCommentInfoV2().commments;
        int i3 = 0;
        for (int i16 = 0; i16 < arrayList2.size(); i16++) {
            Comment comment = arrayList2.get(i16);
            if (i3 < this.F) {
                arrayList.add(new b(comment));
                i3++;
                if (!bl.b(comment.replies)) {
                    for (Reply reply : comment.replies) {
                        if (i3 < this.F) {
                            arrayList.add(new b(comment, reply));
                            i3++;
                        } else if (reply.isTempData) {
                            arrayList.add(new b(comment, reply));
                        }
                    }
                }
            } else if (comment.isTempData) {
                arrayList.add(new b(comment));
            }
        }
        return arrayList;
    }

    private int j0(BusinessFeedData businessFeedData) {
        if (p0(this.D)) {
            return 0;
        }
        ArrayList<Comment> arrayList = businessFeedData.getCommentInfoV2().commments;
        int size = arrayList.size();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            List<Reply> list = arrayList.get(i3).replies;
            if (list != null) {
                size += list.size();
            }
        }
        return size;
    }

    private int k0(BusinessFeedData businessFeedData) {
        if (p0(this.D)) {
            return 0;
        }
        ArrayList<Comment> arrayList = businessFeedData.getCommentInfoV2().commments;
        int i3 = businessFeedData.getCommentInfoV2().commentNum;
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            List<Reply> list = arrayList.get(i16).replies;
            if (list != null) {
                i3 += list.size();
            }
        }
        return i3;
    }

    private boolean o0() {
        return this.H < this.E;
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<b> arrayList = this.C;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return this.C.get(i3).f422674b != null ? 0 : 1;
    }

    public int l0() {
        return this.E;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        if (viewHolder instanceof C10911a) {
            ((C10911a) viewHolder).l(this.D, this.C.get(i3), i3, this.G);
        }
    }

    public void q0(BusinessFeedData businessFeedData, boolean z16) {
        this.D = businessFeedData;
        this.F = m0(businessFeedData);
        if (z16) {
            this.H = k0(businessFeedData);
        } else {
            this.H = j0(businessFeedData);
        }
        this.E = n0(businessFeedData);
        this.C = i0(businessFeedData);
    }

    public void r0(int i3) {
        this.G = i3;
    }

    public boolean s0() {
        return this.E > this.C.size() || o0();
    }

    private int n0(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getCommentInfoV2() == null) {
            return 0;
        }
        return Math.max(businessFeedData.getCommentInfoV2().realCount, this.H);
    }

    private boolean p0(BusinessFeedData businessFeedData) {
        return businessFeedData == null || businessFeedData.getCommentInfoV2() == null || businessFeedData.getCommentInfoV2().commments == null || businessFeedData.getCommentInfoV2().commments.isEmpty();
    }

    public int m0(BusinessFeedData businessFeedData) {
        if (businessFeedData != null && businessFeedData.getFeedCommInfo() != null && businessFeedData.getFeedCommInfo().commentViewNum > 0) {
            return businessFeedData.getFeedCommInfo().commentViewNum;
        }
        RFWLog.e("QZoneCommentAdapter", RFWLog.USR, "commentViewNum is invalid, return default external num");
        return com.qzone.reborn.configx.g.f53821a.b().J0();
    }

    @Override // com.qzone.reborn.base.i
    public RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup viewGroup, int i3) {
        QZoneFeedBaseCommentWidget qZoneFeedReplyWidget;
        if (i3 == 1) {
            qZoneFeedReplyWidget = new QZoneFeedCommentWidget(viewGroup.getContext());
        } else {
            qZoneFeedReplyWidget = new QZoneFeedReplyWidget(viewGroup.getContext());
        }
        qZoneFeedReplyWidget.setPageType(this.f422672m);
        return new C10911a(qZoneFeedReplyWidget);
    }
}
