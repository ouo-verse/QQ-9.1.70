package jn2;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.search.model.aa;
import com.tencent.mobileqq.search.model.t;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.i;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import sn2.a;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class a<M extends t, V extends sn2.a> extends mn2.b<M, V> {
    private int C;
    private List<aa> D;
    private FullMessageSearchResult.SearchResultItem E;
    private String F;
    private int G;
    private String H;
    private QQAppInterface I;

    /* renamed from: i, reason: collision with root package name */
    private int f410654i;

    /* renamed from: m, reason: collision with root package name */
    private int f410655m;

    public a(ListView listView, IFaceDecoder iFaceDecoder, FullMessageSearchResult.SearchResultItem searchResultItem, String str, QQAppInterface qQAppInterface) {
        super(listView, iFaceDecoder);
        this.C = 0;
        if (searchResultItem != null) {
            try {
                this.E = searchResultItem;
                RecentUser recentUser = searchResultItem.user;
                this.F = recentUser.uin;
                this.G = recentUser.getType();
            } catch (NullPointerException e16) {
                QLog.e("Q.uniteSearch.BaseMvpAdapter", 1, "BaseMvpMessageAdapter init e:", e16.toString());
            }
        }
        this.H = str;
        this.I = qQAppInterface;
        this.D = new ArrayList();
    }

    private void h(MessageRecord messageRecord) {
        AbsStructMsg d16;
        if (messageRecord.msgtype == -2011 && (d16 = i.d(messageRecord.msgData)) != null && (d16 instanceof AbsShareMsg)) {
            AbsShareMsg absShareMsg = (AbsShareMsg) d16;
            String str = absShareMsg.mContentTitle;
            messageRecord.f203106msg = str;
            if (TextUtils.isEmpty(str)) {
                messageRecord.f203106msg = absShareMsg.mMsgBrief;
            }
        }
    }

    private void j() {
        if (this.C - this.f410655m == this.f410654i && this.f417043f == 0) {
            i();
        }
    }

    public void i() {
        try {
            int size = this.D.size();
            int i3 = size + 50;
            if (i3 >= this.E.secondPageMessageUniseq.size()) {
                i3 = this.E.secondPageMessageUniseq.size();
            }
            while (size < i3) {
                MessageRecord w06 = this.I.getMessageFacade().w0(this.F, this.G, this.E.secondPageMessageUniseq.get(size).longValue());
                if (w06 != null) {
                    h(w06);
                    if (w06.f203106msg != null) {
                        this.D.add(new aa(this.I, this.H, this.E.user, w06));
                    }
                }
                size++;
            }
        } catch (NullPointerException e16) {
            QLog.e("Q.uniteSearch.BaseMvpAdapter", 1, "initData e:", e16.toString());
        }
        super.g(this.D);
    }

    @Override // mn2.b, com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        this.f410655m = i3;
        this.f410654i = i16;
        this.C = i17;
    }

    @Override // mn2.b, com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        super.onScrollStateChanged(absListView, i3);
        j();
    }
}
