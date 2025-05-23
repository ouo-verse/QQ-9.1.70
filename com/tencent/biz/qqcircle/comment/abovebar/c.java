package com.tencent.biz.qqcircle.comment.abovebar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.variation.HostEmotionUtil;
import com.tencent.biz.qqcircle.beans.QFSCommentKeyboardEmoticonBean;
import com.tencent.biz.qqcircle.comment.at.QFSCommentAtHelper;
import com.tencent.biz.qqcircle.comment.emoji.QFSCommentFastToolsView;
import com.tencent.biz.qqcircle.comment.recpic.aa;
import com.tencent.biz.qqcircle.widgets.comment.CommentEditText;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends com.tencent.biz.qqcircle.comment.abovebar.b {
    private static final int C = (int) RFWApplication.getApplication().getResources().getDimension(R.dimen.d0q);

    /* renamed from: i, reason: collision with root package name */
    private QFSCommentFastToolsView f83300i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f83301m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements QFSCommentFastToolsView.g {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.comment.emoji.QFSCommentFastToolsView.g
        public void a(ImageView imageView, QFSCommentKeyboardEmoticonBean qFSCommentKeyboardEmoticonBean) {
            int selectionStart = c.this.f83296f.getSelectionStart();
            int selectionEnd = c.this.f83296f.getSelectionEnd();
            String emoString = HostEmotionUtil.getEmoString(1, qFSCommentKeyboardEmoticonBean.getLocalId());
            if (!TextUtils.isEmpty(emoString) && c.this.f83296f.getEditableText() != null) {
                if (selectionStart >= 0 && selectionEnd >= 0 && selectionEnd >= selectionStart) {
                    c.this.f83296f.getEditableText().replace(selectionStart, selectionEnd, emoString);
                } else {
                    c.this.f83296f.getEditableText().append((CharSequence) emoString);
                }
                c.this.f83296f.requestFocus();
            }
        }

        @Override // com.tencent.biz.qqcircle.comment.emoji.QFSCommentFastToolsView.g
        public void b(o20.c cVar) {
            if (c.this.f83300i != null && c.this.f83294d != null) {
                QFSCommentAtHelper.r0(true);
                if (c.this.f83294d.O2()) {
                    c.this.f83294d.S8(new ArrayList(cVar.e()));
                    com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement(c.this.getContextHashCode(), c.this.getGroup());
                    return;
                }
                c.this.f83294d.S8(new ArrayList());
            }
        }

        @Override // com.tencent.biz.qqcircle.comment.emoji.QFSCommentFastToolsView.g
        public void c(String str) {
            if (c.this.f83296f.getText().length() > 0) {
                str = "\uff0c" + str;
            }
            c.this.f83296f.append(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f83303d;

        b(boolean z16) {
            this.f83303d = z16;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f83303d) {
                com.tencent.biz.qqcircle.immersive.manager.e.a().reloadGroupActivate(c.this.getContextHashCode(), c.this.getGroup());
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f83303d) {
                c.this.t();
            }
        }
    }

    public c(@NonNull View view, @NonNull com.tencent.biz.qqcircle.comment.abovebar.a aVar, @NonNull CommentEditText commentEditText) {
        super(view, aVar, commentEditText);
        this.f83301m = false;
        n();
    }

    private boolean o() {
        if (!this.f83294d.wg() && !this.f83294d.Of()) {
            return true;
        }
        return false;
    }

    private boolean p() {
        boolean z16;
        if (com.tencent.biz.qqcircle.comment.h.G().I(this.f83294d.getFeed()) == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && !this.f83294d.Of()) {
            return true;
        }
        return false;
    }

    private boolean q() {
        if (!o() && !p() && !this.f83294d.wg() && this.f83294d.O2()) {
            return false;
        }
        return true;
    }

    private void r(boolean z16) {
        if (this.f83300i == null) {
            return;
        }
        QLog.d("QFSCommentFastToolsBar", 4, "[setVisible] " + z16);
        boolean s16 = s();
        if (s16 == z16) {
            QLog.d("QFSCommentFastToolsBar", 4, "currentVisible is same. " + s16);
            return;
        }
        g(this.f83300i, C, z16, new b(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.f83300i == null) {
            return;
        }
        d dVar = new d();
        dVar.f83305a = this.f83294d.O2();
        dVar.f83307c = this.f83294d.wg();
        dVar.f83306b = o();
        dVar.f83308d = p();
        dVar.f83310f = aa.f83750a.e();
        dVar.f83311g = this.f83294d.R4().needShowRecPicLoading;
        this.f83294d.R4().needShowRecPicLoading = false;
        com.tencent.biz.qqcircle.comment.abovebar.a aVar = this.f83294d;
        dVar.f83312h = aVar;
        dVar.f83313i = aVar.d8();
        dVar.f83309e = this.f83294d.ka();
        if (this.f83294d.d8() != null) {
            this.f83300i.setReportBean(this.f83294d.d8().f421796d, dVar.f83308d);
        }
        this.f83300i.W(dVar);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 101;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        if (!this.f83301m && q()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.comment.abovebar.b
    public void j() {
        com.tencent.biz.qqcircle.immersive.manager.e.a().removeElement(this);
        QFSCommentFastToolsView qFSCommentFastToolsView = this.f83300i;
        if (qFSCommentFastToolsView != null) {
            qFSCommentFastToolsView.setOnReplyClickListener(null);
        }
    }

    @Override // com.tencent.biz.qqcircle.comment.abovebar.b
    public void k(boolean z16) {
        this.f83301m = z16;
        if (z16) {
            r(false);
        } else {
            com.tencent.biz.qqcircle.immersive.manager.e.a().reloadGroupActivate(getContextHashCode(), getGroup());
        }
    }

    public void n() {
        QFSCommentFastToolsView qFSCommentFastToolsView = (QFSCommentFastToolsView) this.f83295e.findViewById(R.id.f354311u);
        this.f83300i = qFSCommentFastToolsView;
        if (qFSCommentFastToolsView == null) {
            return;
        }
        qFSCommentFastToolsView.setFeed(this.f83294d.getFeed());
        this.f83300i.setOnReplyClickListener(new a());
        this.f83300i.setVisibility(8);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        r(true);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        r(false);
    }

    public boolean s() {
        QFSCommentFastToolsView qFSCommentFastToolsView = this.f83300i;
        if (qFSCommentFastToolsView != null && qFSCommentFastToolsView.getVisibility() == 0) {
            return true;
        }
        return false;
    }
}
