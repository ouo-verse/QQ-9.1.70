package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ap {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, f> f82110a;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements f {
        a() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.ap.f
        public com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> a(WSVerticalPageFragment wSVerticalPageFragment, au auVar) {
            return new q(wSVerticalPageFragment.getActivity(), auVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements f {
        b() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.ap.f
        public com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> a(WSVerticalPageFragment wSVerticalPageFragment, au auVar) {
            return new q(wSVerticalPageFragment.getActivity(), auVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class c implements f {
        c() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.ap.f
        public com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> a(WSVerticalPageFragment wSVerticalPageFragment, au auVar) {
            return new o(wSVerticalPageFragment.getActivity(), auVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class d implements f {
        d() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.ap.f
        public com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> a(WSVerticalPageFragment wSVerticalPageFragment, au auVar) {
            return new o(wSVerticalPageFragment.getActivity(), auVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class e implements f {
        e() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.ap.f
        public com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> a(WSVerticalPageFragment wSVerticalPageFragment, au auVar) {
            return new o(wSVerticalPageFragment.getActivity(), auVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private interface f {
        com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> a(WSVerticalPageFragment wSVerticalPageFragment, au auVar);
    }

    static {
        HashMap hashMap = new HashMap();
        f82110a = hashMap;
        hashMap.put("vertical_layer_collection", new a());
        hashMap.put("vertical_layer_collection_of_card", new b());
        hashMap.put("drama_preview", new c());
        hashMap.put("drama_history", new d());
        hashMap.put("drama_collection", new e());
    }

    public static com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> a(WSVerticalPageFragment wSVerticalPageFragment, String str, au auVar) {
        f fVar = f82110a.get(str);
        if (fVar != null) {
            return fVar.a(wSVerticalPageFragment, auVar);
        }
        return new l(wSVerticalPageFragment.getActivity(), auVar);
    }
}
