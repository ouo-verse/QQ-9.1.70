package i9;

import android.text.TextUtils;
import androidx.recyclerview.widget.DiffUtil;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c extends com.qzone.reborn.base.h<com.qzone.reborn.albumx.common.bean.e> {

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class a extends DiffUtil.ItemCallback<com.qzone.reborn.albumx.common.bean.e> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(com.qzone.reborn.albumx.common.bean.e eVar, com.qzone.reborn.albumx.common.bean.e eVar2) {
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(com.qzone.reborn.albumx.common.bean.e eVar, com.qzone.reborn.albumx.common.bean.e eVar2) {
            return TextUtils.equals(eVar.getStateData().getUrl(), eVar2.getStateData().getUrl());
        }
    }

    public c() {
        super(new a(), new AdapterDelegatesManager(new m9.g()));
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        if (getItems().size() > i3) {
            return getItems().get(i3).getStateData().getUrl().hashCode();
        }
        return super.getItemId(i3);
    }
}
