package k00;

import UserGrowth.stFriendLike;
import UserGrowth.stFriendLikes;
import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaFeed;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.weishi.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi.report.WSFollowBeaconReport;
import com.tencent.biz.pubaccount.weishi.util.WSNumUtil;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.BaseApplication;
import h00.j;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static int f411324a = ScreenUtil.getRealWidth(BaseApplication.context) - ScreenUtil.dip2px(30.0f);

    /* renamed from: b, reason: collision with root package name */
    private static String f411325b = "\u3001";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class a extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        private stSchema f411326d;

        /* renamed from: e, reason: collision with root package name */
        private stSimpleMetaFeed f411327e;

        /* renamed from: f, reason: collision with root package name */
        private int f411328f;

        /* compiled from: P */
        /* renamed from: k00.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes38.dex */
        class C10623a extends h00.d {
            C10623a() {
            }

            @Override // h00.d, h00.b
            public void a() {
                a aVar = a.this;
                aVar.d(aVar.f411327e, 1000004);
            }

            @Override // h00.d, h00.b
            public void b() {
                a aVar = a.this;
                aVar.d(aVar.f411327e, 1000002);
            }

            @Override // h00.d, h00.b
            public void c() {
                a aVar = a.this;
                aVar.d(aVar.f411327e, 1000007);
            }

            @Override // h00.d, h00.b
            public void d() {
                a aVar = a.this;
                aVar.d(aVar.f411327e, 1000003);
            }
        }

        a(stSimpleMetaFeed stsimplemetafeed, stSchema stschema, int i3) {
            this.f411327e = stsimplemetafeed;
            this.f411326d = stschema;
            this.f411328f = i3;
        }

        private static WSDownloadParams c(String str) {
            WSDownloadParams wSDownloadParams = new WSDownloadParams();
            wSDownloadParams.mScene = 1;
            wSDownloadParams.mLinkStrategyType = iz.a.g().p();
            wSDownloadParams.mTestId = bb.x(wSDownloadParams.mScene);
            wSDownloadParams.mScheme = str;
            return wSDownloadParams;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(stSimpleMetaFeed stsimplemetafeed, int i3) {
            WSFollowBeaconReport.i(GuildMsgItem.NICK_FRIEND, this.f411328f, String.valueOf(i3), stsimplemetafeed);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            x.i("WSFriendLikeUtil", "schema = " + this.f411326d.toString());
            if (bb.E()) {
                return;
            }
            new j(view.getContext()).o(this.f411326d).i(c(this.f411326d.schema)).m(new C10623a()).h();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
        }
    }

    private static a a(stSimpleMetaFeed stsimplemetafeed, stFriendLike stfriendlike, int i3) {
        return new a(stsimplemetafeed, stfriendlike.schema, i3);
    }

    private static String b() {
        return " \u8d5e\u4e86";
    }

    private static String c(int i3) {
        return " \u7b49" + e(i3) + "\u4f4d\u597d\u53cb\u8d5e\u4e86";
    }

    private static String d(int i3) {
        return e(i3) + "\u4f4d\u597d\u53cb \u8d5e\u4e86";
    }

    private static String e(int i3) {
        return WSNumUtil.c(i3);
    }

    public static d f(stSimpleMetaFeed stsimplemetafeed, TextPaint textPaint, int i3) {
        stFriendLikes stfriendlikes;
        int i16;
        int i17;
        String sb5;
        TextPaint textPaint2 = textPaint;
        long currentTimeMillis = System.currentTimeMillis();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int i18 = 0;
        if (stsimplemetafeed != null && (stfriendlikes = stsimplemetafeed.friendLikes) != null && (i16 = stfriendlikes.total) > 0 && textPaint2 != null) {
            ArrayList<stFriendLike> arrayList = stfriendlikes.likeFriends;
            if (arrayList == null) {
                x.j("WSFriendLikeUtil", "[WSFriendLikeParser.parse()]friendLikes.likeFriends is empty\uff0cbut friendLikes.total > 0\uff0cshow the num");
                return new d(null, 0, d(i16));
            }
            int size = arrayList.size();
            int measureText = (int) textPaint2.measureText(b());
            int measureText2 = (int) textPaint2.measureText(c(i16));
            int i19 = f411324a;
            int i26 = i19 - measureText;
            int i27 = i19 - measureText2;
            float f16 = 0.0f;
            int i28 = 0;
            while (i18 < size) {
                stFriendLike stfriendlike = stfriendlikes.likeFriends.get(i18);
                String str = stfriendlike.nick;
                stFriendLikes stfriendlikes2 = stfriendlikes;
                if (i18 == size - 1) {
                    i17 = size;
                    sb5 = str;
                } else {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(str);
                    i17 = size;
                    sb6.append(f411325b);
                    sb5 = sb6.toString();
                }
                spannableStringBuilder.append((CharSequence) sb5);
                float measureText3 = textPaint2.measureText(spannableStringBuilder.toString());
                if (measureText3 > i26) {
                    x.i("WSFriendLikeUtil", "[WSFriendLikeParser.parse()]the cost of friendLikes'Parsing\uff1a " + (System.currentTimeMillis() - currentTimeMillis));
                    x.j("WSFriendLikeUtil", "[WSFriendLikeParser.parse()]the width of friendLikes is out of the max width\uff0cshow with ...");
                    return new d(spannableStringBuilder, i27, c(i16));
                }
                spannableStringBuilder.setSpan(a(stsimplemetafeed, stfriendlike, i3), i28, str.length() + i28, 33);
                i28 += sb5.length();
                i18++;
                textPaint2 = textPaint;
                f16 = measureText3;
                stfriendlikes = stfriendlikes2;
                size = i17;
            }
            x.i("WSFriendLikeUtil", "[WSFriendLikeParser.parse()]the cost of friendLikes'Parsing\uff1a " + (System.currentTimeMillis() - currentTimeMillis));
            x.j("WSFriendLikeUtil", "[WSFriendLikeParser.parse()]the width of friendLikes is in the max width\uff0cshow completely");
            return new d(spannableStringBuilder, (int) f16, b());
        }
        x.j("WSFriendLikeUtil", "[WSFriendLikeParser.parse()]friendLikes is empty\uff0chide displayLine");
        return new d(null, 0, "");
    }
}
