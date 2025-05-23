package cooperation.qqfav.globalsearch;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.model.z;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.text.QQText;
import cooperation.qqfav.QfavHelper;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b extends z {
    private static ForegroundColorSpan Z = new ForegroundColorSpan(com.tencent.mobileqq.search.util.a.a());
    public long G;
    public long H;
    public long I;
    public String J;
    public String K;
    public String L;
    public int M;
    public int N;
    public int P;
    public String Q;
    public int R;
    public byte[] S;
    public int T;
    public int U;
    public boolean V;
    public int W;
    public int X;
    private CharSequence Y;

    public b() {
        C(15);
    }

    public void G() {
        D(String.valueOf(this.H));
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        int i3 = this.T;
        if (i3 == 1) {
            return 1;
        }
        if (i3 != 2) {
            if (i3 != 3) {
                return 0;
            }
            return 101;
        }
        return 4;
    }

    @Override // com.tencent.mobileqq.search.model.t
    /* renamed from: l */
    public String getUin() {
        if (this.I == 0) {
            return null;
        }
        return "" + this.I;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: m */
    public CharSequence getDescription() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.L != null) {
            if (this.M == 1) {
                spannableStringBuilder.append((CharSequence) "\u6765\u81ea: ").append((CharSequence) this.L).setSpan(Z, this.N + 4, this.P + 4, 33);
                return spannableStringBuilder;
            }
            return spannableStringBuilder.append((CharSequence) "\u6765\u81ea: ").append(SearchUtils.D(this.L, this.J, 30));
        }
        return spannableStringBuilder;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public CharSequence o() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public boolean r() {
        return false;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: s */
    public String getKeyword() {
        return this.J;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: t */
    public CharSequence getSubTitle() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: u */
    public CharSequence getTitle() {
        int i3;
        int i16;
        if (this.Y == null && this.K != null) {
            QQText qQText = new QQText(this.K, 3, 20);
            if (this.M == 0 && (i3 = this.P) > (i16 = this.N)) {
                qQText.setSpan(Z, i16, i3, 33);
            }
            this.Y = qQText;
        }
        return this.Y;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public void v(View view) {
        if (hf0.a.b("FavoriteSearchResultMod", 1000L)) {
            return;
        }
        QBaseActivity qBaseActivity = (QBaseActivity) view.getContext();
        QfavHelper.u(qBaseActivity, qBaseActivity.getAppRuntime().getAccount(), this.G);
        SearchUtils.c1(this.J, 60, 0, view);
        if (qBaseActivity instanceof UniteSearchActivity) {
            SearchUtils.W0("all_result", "clk_collect", "" + this.J);
        }
    }
}
