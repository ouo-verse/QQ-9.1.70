package com.tencent.aelight.camera.aioeditor;

import NS_QQ_STORY_CLIENT.CLIENT$StBatchGetMusicInfoRsp;
import NS_QQ_STORY_META.META$StMusic;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.tencent.aelight.camera.aioeditor.EditVideoSmartMusicPart;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.BatchGetMusicInfoRequest;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import qqcircle.QQCircleSmartMatchMusic$MusicInfo;

/* compiled from: P */
/* loaded from: classes32.dex */
public class SmartMusicAdapter extends RecyclerView.Adapter<b> implements Handler.Callback {

    /* renamed from: e, reason: collision with root package name */
    private EditVideoSmartMusicPart.g f66298e;

    /* renamed from: h, reason: collision with root package name */
    private SmartMusicRecyclerView f66300h;

    /* renamed from: i, reason: collision with root package name */
    private nf0.a f66301i;

    /* renamed from: m, reason: collision with root package name */
    private WeakReferenceHandler f66302m;

    /* renamed from: d, reason: collision with root package name */
    private List<VsMusicItemInfo> f66297d = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private HashMap<String, Integer> f66299f = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f66306d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ VsMusicItemInfo f66307e;

        a(int i3, VsMusicItemInfo vsMusicItemInfo) {
            this.f66306d = i3;
            this.f66307e = vsMusicItemInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (SmartMusicAdapter.this.f66298e != null) {
                SmartMusicAdapter.this.f66298e.a(this.f66306d, this.f66307e);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name */
        private final View f66309d;

        /* renamed from: e, reason: collision with root package name */
        private ImageView f66310e;

        /* renamed from: f, reason: collision with root package name */
        private View f66311f;

        /* renamed from: h, reason: collision with root package name */
        private boolean f66312h;

        public b(View view) {
            super(view);
            this.f66310e = (ImageView) view.findViewById(R.id.rw5);
            this.f66311f = view.findViewById(R.id.rtq);
            this.f66309d = view.findViewById(R.id.rxj);
        }

        private RotateAnimation c() {
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(3000L);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            rotateAnimation.setRepeatCount(-1);
            return rotateAnimation;
        }

        public void d() {
            if (this.f66312h) {
                return;
            }
            this.f66310e.startAnimation(c());
            this.f66312h = true;
        }

        public void e() {
            this.f66310e.clearAnimation();
            this.f66312h = false;
        }

        public void f() {
            g(true);
        }

        public void h() {
            i(true);
        }

        public void g(boolean z16) {
            if (z16) {
                if (this.f66310e.getVisibility() == 8) {
                    this.f66310e.setVisibility(0);
                }
                if (this.f66311f.getVisibility() == 8) {
                    this.f66311f.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.f66311f.getVisibility() == 0) {
                this.f66311f.setVisibility(8);
            }
        }

        public void i(boolean z16) {
            if (z16) {
                if (this.f66309d.getVisibility() == 8) {
                    this.f66309d.setVisibility(0);
                }
            } else if (this.f66309d.getVisibility() == 0) {
                this.f66309d.setVisibility(8);
            }
        }
    }

    private int x(int i3) {
        if (w() == 0) {
            return 0;
        }
        return i3 % w();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i3) {
        if (w() == 0) {
            return;
        }
        VsMusicItemInfo vsMusicItemInfo = this.f66297d.get(i3 < w() ? i3 : x(i3));
        if (vsMusicItemInfo != null) {
            if (vsMusicItemInfo.isDownloading()) {
                bVar.h();
            } else {
                bVar.i(false);
            }
            UIUtils.q(bVar.f66310e, vsMusicItemInfo.mAlbumUrl, UIUtils.b(bVar.itemView.getContext(), 60.0f), UIUtils.b(bVar.itemView.getContext(), 60.0f), UIUtils.b(bVar.itemView.getContext(), 30.0f), bVar.itemView.getContext().getResources().getDrawable(R.drawable.f160367gc), null);
            bVar.itemView.setOnClickListener(new a(i3, vsMusicItemInfo));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dou, (ViewGroup) null));
    }

    public void D(ArrayList<String> arrayList, final boolean z16) {
        VSNetworkHelper.getInstance().sendRequest(new BatchGetMusicInfoRequest(arrayList), new VSDispatchObserver.OnVSRspCallBack<CLIENT$StBatchGetMusicInfoRsp>() { // from class: com.tencent.aelight.camera.aioeditor.SmartMusicAdapter.2
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceive(BaseRequest baseRequest, boolean z17, long j3, String str, CLIENT$StBatchGetMusicInfoRsp cLIENT$StBatchGetMusicInfoRsp) {
                int intValue;
                if (!z17 || cLIENT$StBatchGetMusicInfoRsp.vecMusic.size() == 0) {
                    return;
                }
                for (int i3 = 0; i3 < cLIENT$StBatchGetMusicInfoRsp.vecMusic.size(); i3++) {
                    META$StMusic mETA$StMusic = cLIENT$StBatchGetMusicInfoRsp.vecMusic.get(i3);
                    if (mETA$StMusic != null && (intValue = ((Integer) SmartMusicAdapter.this.f66299f.get(mETA$StMusic.strSongMid.get())).intValue()) >= 0 && intValue < SmartMusicAdapter.this.f66297d.size()) {
                        VsMusicItemInfo vsMusicItemInfo = (VsMusicItemInfo) SmartMusicAdapter.this.f66297d.get(intValue);
                        if (vsMusicItemInfo.mSongMid.equals(mETA$StMusic.strSongMid.get())) {
                            vsMusicItemInfo.a(mETA$StMusic);
                            vsMusicItemInfo.f97249h = true;
                            if (!StringUtil.isEmpty(str)) {
                                vsMusicItemInfo.f97250i = str;
                            }
                        }
                    }
                }
                SmartMusicAdapter.this.z().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.SmartMusicAdapter.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SmartMusicAdapter.this.f66298e == null || SmartMusicAdapter.this.f66301i == null) {
                            return;
                        }
                        int e16 = SmartMusicAdapter.this.f66301i.e() % SmartMusicAdapter.this.w();
                        SmartMusicAdapter.this.f66298e.c((VsMusicItemInfo) SmartMusicAdapter.this.f66297d.get(e16), e16, z16);
                    }
                });
            }
        });
    }

    public void F(ArrayList<VsMusicItemInfo> arrayList) {
        this.f66297d = arrayList;
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            this.f66299f.put(arrayList.get(i3).mSongMid, Integer.valueOf(i3));
            arrayList2.add(arrayList.get(i3).mSongMid);
        }
        C(arrayList2);
        notifyDataSetChanged();
    }

    public void G(EditVideoSmartMusicPart.g gVar) {
        this.f66298e = gVar;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1000;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        SmartMusicRecyclerView smartMusicRecyclerView = (SmartMusicRecyclerView) recyclerView;
        this.f66300h = smartMusicRecyclerView;
        this.f66301i = smartMusicRecyclerView.d();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        z().removeCallbacks(null);
    }

    public void setData(List<QQCircleSmartMatchMusic$MusicInfo> list) {
        List<VsMusicItemInfo> list2;
        if (w() == 0) {
            list2 = new ArrayList<>();
        } else {
            list2 = this.f66297d;
        }
        this.f66297d = list2;
        ArrayList<String> arrayList = new ArrayList<>();
        int w3 = w();
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.f66299f.put(list.get(i3).lyricInfo.strSongMid.get(), Integer.valueOf(w3 == 0 ? i3 : w() + i3));
            this.f66297d.add(new VsMusicItemInfo(list.get(i3)));
            arrayList.add(list.get(i3).lyricInfo.strSongMid.get());
        }
        C(arrayList);
        notifyDataSetChanged();
    }

    public boolean t(int i3, VsMusicItemInfo vsMusicItemInfo) {
        if (this.f66299f.get(vsMusicItemInfo.mSongMid) != null) {
            return false;
        }
        int x16 = x(i3);
        this.f66299f.put(vsMusicItemInfo.mSongMid, Integer.valueOf(x16));
        this.f66297d.add(x16, vsMusicItemInfo);
        E(this.f66297d);
        notifyDataSetChanged();
        return true;
    }

    public List<VsMusicItemInfo> u() {
        return this.f66297d;
    }

    public VsMusicItemInfo v(int i3) {
        if (i3 >= w()) {
            i3 = x(i3);
        }
        List<VsMusicItemInfo> list = this.f66297d;
        if (list == null || i3 < 0 || i3 >= list.size()) {
            return null;
        }
        return this.f66297d.get(i3);
    }

    public int w() {
        List<VsMusicItemInfo> list = this.f66297d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int y(String str) {
        return this.f66299f.get(str).intValue();
    }

    public WeakReferenceHandler z() {
        if (this.f66302m == null) {
            this.f66302m = new WeakReferenceHandler(Looper.getMainLooper(), this);
        }
        return this.f66302m;
    }

    private void E(List<VsMusicItemInfo> list) {
        for (int i3 = 0; i3 < w(); i3++) {
            this.f66299f.put(list.get(i3).mSongMid, Integer.valueOf(i3));
        }
    }

    public void C(ArrayList<String> arrayList) {
        D(arrayList, false);
    }
}
