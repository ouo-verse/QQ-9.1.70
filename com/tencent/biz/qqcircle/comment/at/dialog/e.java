package com.tencent.biz.qqcircle.comment.at.dialog;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e extends AsyncListDifferDelegationAdapter<o20.b> {

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends DiffUtil.ItemCallback<o20.b> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NonNull o20.b bVar, @NonNull o20.b bVar2) {
            if (TextUtils.equals(bVar.a().uin, bVar2.a().uin) && bVar.a().uinType == bVar2.a().uinType) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NonNull o20.b bVar, @NonNull o20.b bVar2) {
            return true;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @NonNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Object getChangePayload(@NonNull o20.b bVar, @NonNull o20.b bVar2) {
            return new Object();
        }
    }

    public e() {
        this(0);
    }

    public e(int i3) {
        super(new a());
        this.delegatesManager.addDelegate(new p20.e(i3));
    }
}
