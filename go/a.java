package go;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.model.User;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.richframework.text.rich.bean.RichTextPreloadParserInfo;
import com.tencent.richframework.text.rich.event.RichTextPreloadEvent;
import com.tencent.richframework.text.rich.parser.IParseRuleStrategyParser;
import com.tencent.richframework.text.rich.span.BoldClickableSpan;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements IParseRuleStrategyParser<CellLikeInfo> {

    /* renamed from: a, reason: collision with root package name */
    private BoldClickableSpan.OnClickBoldTextListener f402692a;

    /* renamed from: b, reason: collision with root package name */
    private RichTextPreloadParserInfo f402693b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: go.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public class C10390a implements BoldClickableSpan.OnClickBoldTextListener {
        C10390a() {
        }

        @Override // com.tencent.richframework.text.rich.span.BoldClickableSpan.OnClickBoldTextListener
        public void onClick(Object obj) {
            if (obj instanceof RichTextPreloadEvent) {
                RichTextPreloadEvent richTextPreloadEvent = (RichTextPreloadEvent) obj;
                if (a.this.f402693b != null) {
                    richTextPreloadEvent.cacheKey = a.this.f402693b.getCacheKey();
                }
                SimpleEventBus.getInstance().dispatchEvent(richTextPreloadEvent);
            }
        }
    }

    private void b(SpannableStringBuilder spannableStringBuilder, int i3, int i16, BoldClickableSpan.OnClickBoldTextListener onClickBoldTextListener, int i17, boolean z16, RichTextPreloadEvent richTextPreloadEvent) {
        if (TextUtils.isEmpty(spannableStringBuilder) || i16 < i3 || spannableStringBuilder.length() < i16) {
            return;
        }
        spannableStringBuilder.setSpan(new BoldClickableSpan(onClickBoldTextListener, BaseApplication.getContext().getResources().getColor(i17), z16, richTextPreloadEvent), i3, i16, 33);
    }

    private void c() {
        if (this.f402692a == null) {
            this.f402692a = new C10390a();
        }
    }

    @Override // com.tencent.richframework.text.rich.parser.IParseRuleStrategyParser
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public SpannableStringBuilder ruleParse(CellLikeInfo cellLikeInfo, RichTextPreloadParserInfo richTextPreloadParserInfo) {
        if (cellLikeInfo == null || richTextPreloadParserInfo == null || richTextPreloadParserInfo.getConfig() == null) {
            return null;
        }
        this.f402693b = richTextPreloadParserInfo;
        return e(cellLikeInfo, richTextPreloadParserInfo);
    }

    public SpannableStringBuilder e(CellLikeInfo cellLikeInfo, RichTextPreloadParserInfo richTextPreloadParserInfo) {
        String string;
        User user;
        String str;
        ArrayList<CellLikeInfo.LikeMan> arrayList = cellLikeInfo.likeMans;
        int min = Math.min(15, arrayList.size());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i3 = 0; i3 < min; i3++) {
            CellLikeInfo.LikeMan likeMan = arrayList.get(i3);
            if (likeMan != null && (user = likeMan.user) != null) {
                if (TextUtils.isEmpty(user.nickName)) {
                    str = String.valueOf(user.uin);
                } else {
                    str = user.nickName;
                }
                if (i3 < min - 1) {
                    str = str + "\u3001 ";
                }
                int length = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) str);
                int length2 = (str.length() + length) - 1;
                c();
                RichTextPreloadEvent richTextPreloadEvent = new RichTextPreloadEvent(6, richTextPreloadParserInfo.getPreloadBusinessTag(), richTextPreloadParserInfo.getCacheKey());
                richTextPreloadEvent.uin = String.valueOf(user.uin);
                b(spannableStringBuilder, length, length2, this.f402692a, R.color.qui_common_text_primary, false, richTextPreloadEvent);
            }
        }
        int length3 = spannableStringBuilder.length();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(" ");
        if (cellLikeInfo.likeNum == 1) {
            string = BaseApplication.getContext().getString(R.string.f169536pb0);
        } else {
            string = BaseApplication.getContext().getString(R.string.mvl, Integer.valueOf(cellLikeInfo.likeNum));
        }
        sb5.append(string);
        String sb6 = sb5.toString();
        spannableStringBuilder.append((CharSequence) sb6);
        int length4 = (sb6.length() + length3) - 1;
        RichTextPreloadEvent richTextPreloadEvent2 = new RichTextPreloadEvent(6, richTextPreloadParserInfo.getPreloadBusinessTag(), richTextPreloadParserInfo.getCacheKey());
        richTextPreloadEvent2.uin = BaseApplication.getContext().getString(R.string.ode);
        b(spannableStringBuilder, length3, length4, this.f402692a, R.color.qui_common_text_primary, false, richTextPreloadEvent2);
        return spannableStringBuilder;
    }
}
