package cn;

import androidx.recyclerview.widget.DiffUtil;
import com.qzone.reborn.base.h;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import java.util.Objects;
import qzonemoment.QZMomentMeta$StComment;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a extends h<QZMomentMeta$StComment> {

    /* compiled from: P */
    /* renamed from: cn.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    class C0207a extends DiffUtil.ItemCallback<QZMomentMeta$StComment> {
        C0207a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(QZMomentMeta$StComment qZMomentMeta$StComment, QZMomentMeta$StComment qZMomentMeta$StComment2) {
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(QZMomentMeta$StComment qZMomentMeta$StComment, QZMomentMeta$StComment qZMomentMeta$StComment2) {
            return Objects.equals(qZMomentMeta$StComment.f430361id.get(), qZMomentMeta$StComment2.f430361id.get());
        }
    }

    public a() {
        super(new C0207a(), new AdapterDelegatesManager(new com.qzone.reborn.qzmoment.itemview.a()));
    }
}
