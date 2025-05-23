package com.tencent.mobileqq.search.model;

import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.IMessageFacadeFetcher;
import com.tencent.mobileqq.search.api.IQQSearchApi;
import com.tencent.mobileqq.search.api.ISearchReportFetcher;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class k extends z implements Cloneable {
    public static final String W = "k";
    public AppInterface G;
    private long H = -1;
    protected int I;
    protected long J;
    private long K;
    protected String L;
    public boolean M;
    protected boolean N;
    private CharSequence P;
    protected CharSequence Q;
    private String R;
    protected String S;
    private String T;
    protected String U;
    public HashMap<String, String> V;

    public k(AppInterface appInterface, int i3, long j3) {
        this.N = false;
        this.G = appInterface;
        this.I = i3;
        this.J = j3;
        this.N = com.tencent.mobileqq.search.util.b.a().b();
    }

    public abstract Object G();

    public int H() {
        return 0;
    }

    public final long I() {
        return this.K;
    }

    public long J() {
        if (this.H == -1) {
            Message lastMessage = ((IMessageFacadeFetcher) QRoute.api(IMessageFacadeFetcher.class)).getLastMessage(l(), M());
            if (lastMessage != null) {
                this.H = lastMessage.time;
            } else {
                this.H = 0L;
            }
        }
        return this.H;
    }

    public abstract String K();

    public abstract String L();

    public abstract int M();

    protected abstract long N(String str);

    public final long O(String str) {
        long N = N(str);
        if (N != Long.MIN_VALUE && P()) {
            N += this.J << SearchConfig.contactSearchRecentBaseBit;
        }
        this.K = N;
        return N;
    }

    protected boolean P() {
        return true;
    }

    public void Q(String str) {
        this.L = str;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Override // com.tencent.mobileqq.search.model.t
    public abstract String l();

    @Override // com.tencent.mobileqq.search.model.y
    public CharSequence t() {
        String K = K();
        if (!TextUtils.isEmpty(K)) {
            if (!K.equals(this.U) || !TextUtils.equals(this.S, s())) {
                this.U = K;
                this.S = s();
                boolean z16 = this.M;
                this.Q = ((IQQSearchApi) QRoute.api(IQQSearchApi.class)).getMessageWithParenthese(((IQQSearchApi) QRoute.api(IQQSearchApi.class)).getHighLightMatchedMessage(K, s()));
            }
            return this.Q;
        }
        this.U = null;
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public CharSequence u() {
        String L = L();
        if (!TextUtils.isEmpty(L)) {
            if (!L.equals(this.T) || !TextUtils.equals(this.R, s())) {
                this.T = L;
                this.R = s();
                boolean z16 = this.M;
                this.P = ((IQQSearchApi) QRoute.api(IQQSearchApi.class)).getHighLightMatchedMessageForMainTitle(this.G, L, s());
            }
            CharSequence charSequence = this.P;
            if (charSequence == null) {
                return "";
            }
            return charSequence;
        }
        if (QLog.isColorLevel()) {
            QLog.d(W, 2, "getTitle str is null");
        }
        this.T = null;
        return "";
    }

    @Override // com.tencent.mobileqq.search.model.y
    public void v(View view) {
        String str = W;
        QLog.d(str, 2, "onAction   class:" + getClass().getName());
        ((ISearchReportFetcher) QRoute.api(ISearchReportFetcher.class)).onActionContactSearchModel(this, view, s(), this.I, str);
    }
}
