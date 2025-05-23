package com.tencent.biz.qqcircle.drawer;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e extends AsyncListDifferDelegationAdapter<f> {

    /* renamed from: m, reason: collision with root package name */
    private h f84393m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends DiffUtil.ItemCallback<f> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NonNull f fVar, @NonNull f fVar2) {
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NonNull f fVar, @NonNull f fVar2) {
            if (fVar.b() == fVar2.b()) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @NonNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Object getChangePayload(@NonNull f fVar, @NonNull f fVar2) {
            return new Object();
        }
    }

    public e() {
        super(new a());
        this.delegatesManager.addDelegate(new QFSDrawerCommonItemDelegate());
        this.delegatesManager.addDelegate(new b());
        h hVar = new h();
        this.f84393m = hVar;
        this.delegatesManager.addDelegate(hVar);
    }

    public h i0() {
        h hVar = this.f84393m;
        if (hVar != null) {
            return hVar;
        }
        return null;
    }
}
