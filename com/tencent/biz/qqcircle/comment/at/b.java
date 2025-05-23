package com.tencent.biz.qqcircle.comment.at;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter;
import p20.d;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends AsyncListDifferDelegationAdapter<o20.c> {

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends DiffUtil.ItemCallback<o20.c> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NonNull o20.c cVar, @NonNull o20.c cVar2) {
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NonNull o20.c cVar, @NonNull o20.c cVar2) {
            if (cVar.f() == cVar2.f()) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @NonNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Object getChangePayload(@NonNull o20.c cVar, @NonNull o20.c cVar2) {
            return new Object();
        }
    }

    public b() {
        super(new a());
        this.delegatesManager.addDelegate(new d()).addDelegate(new p20.c()).addDelegate(new p20.b()).addDelegate(new p20.a());
    }
}
