package com.qzone.reborn.feedx.widget.comment;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.proxy.feedcomponent.model.ClickedComment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.publish.ui.model.QzoneVipCommentIconInfo;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.reborn.feedx.widget.b;
import com.qzone.reborn.feedx.widget.comment.QZoneFeedReplyWidget;
import com.qzone.util.ar;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.mobileqq.R;
import gf.e;
import java.util.List;
import oh.c;
import x8.d;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFeedReplyWidget extends QZoneFeedBaseCommentWidget {

    /* renamed from: m, reason: collision with root package name */
    private QZoneRichTextView f56005m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements CellTextView.d {
        a() {
        }

        @Override // com.qzone.proxy.feedcomponent.text.CellTextView.d
        public List<TextCell> a(List<TextCell> list) {
            return b.b(list, QZoneFeedReplyWidget.this.getResources().getColor(R.color.qui_common_text_primary), true);
        }
    }

    public QZoneFeedReplyWidget(Context context) {
        super(context);
        B0();
    }

    private void B0() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        QZoneRichTextView qZoneRichTextView = (QZoneRichTextView) findViewById(R.id.naw);
        this.f56005m = qZoneRichTextView;
        qZoneRichTextView.setLineSpace(ImmersiveUtils.dpToPx(1.0f));
        this.f56005m.setTextColorLink(getResources().getColor(R.color.qui_common_text_link));
        this.f56005m.setTextSize(ar.e(14.0f));
        this.f56005m.setPreDecorateListener(new a());
        u0(this.f56005m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(String str, e eVar) {
        eVar.k5(this.f56005m, "em_qz_comment_information", str, this.f55996e);
    }

    private void D0(String str, Reply reply) {
        boolean isEmpty = TextUtils.isEmpty(reply.content);
        this.f56005m.setDrawBackground(true);
        this.f56005m.setColorBackground(getResources().getColor(R.color.qui_common_fill_light_secondary_pressed));
        QZoneRichTextView qZoneRichTextView = this.f56005m;
        if (isEmpty) {
            str = "";
        }
        qZoneRichTextView.setRichText(str);
    }

    private String y0(Reply reply, String str) {
        StringBuilder sb5 = new StringBuilder();
        if (reply.user != null && reply.targetUser != null) {
            sb5.append(str);
            if (reply.user.uin != reply.targetUser.uin) {
                sb5.append("{text:");
                sb5.append(" \u56de\u590d ");
                sb5.append(",color:");
                sb5.append(Integer.toHexString(j.o()));
                sb5.append(",useDefaultFont:1,useSuperFont:0}");
                sb5.append(gh.a.a(reply.targetUser, true));
            }
            sb5.append(reply.content);
            return sb5.toString();
        }
        return "";
    }

    private String z0(Reply reply) {
        String e16 = ch.j.e(q0());
        QzoneVipCommentIconInfo qzoneVipCommentIconInfo = reply.user.vipCommentInfo;
        return gh.a.c(reply.user, new d.a(qzoneVipCommentIconInfo.f51898d, e16, qzoneVipCommentIconInfo.f51899e, qzoneVipCommentIconInfo.f51900f, Boolean.TRUE));
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.chd;
    }

    @Override // com.qzone.reborn.feedx.widget.comment.QZoneFeedBaseCommentWidget
    protected String getLogTag() {
        return "QZoneFeedReplyWidget";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public void bindData(oh.b bVar, int i3) {
        String a16;
        Reply reply = bVar.f422674b;
        this.f56005m.setVisibility(TextUtils.isEmpty(reply.content) ? 8 : 0);
        this.f56005m.setFont(reply.getFontId(false), reply.getFontUrl(false), reply.getFontType(false));
        c.a(this.f56005m, reply.getSuperFontInfo(false));
        ClickedComment clickedComment = new ClickedComment();
        clickedComment.setReply(reply);
        this.f56005m.setTag(clickedComment);
        User user = reply.user;
        if (user != null && ch.j.g(user.vipCommentInfo)) {
            a16 = z0(reply);
        } else {
            a16 = gh.a.a(reply.user, false);
        }
        D0(y0(reply, a16), reply);
        A0(reply);
    }

    private void A0(Reply reply) {
        if (reply == null || this.f56005m == null) {
            return;
        }
        final String str = reply.uinKey;
        RFWIocAbilityProvider.g().getIoc(e.class).originView(this).done(new OnPromiseResolved() { // from class: oh.f
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                QZoneFeedReplyWidget.this.C0(str, (gf.e) obj);
            }
        }).run();
    }
}
