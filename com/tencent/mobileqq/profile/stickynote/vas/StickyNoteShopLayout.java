package com.tencent.mobileqq.profile.stickynote.vas;

import QC.GetSuixintieSigFontReq;
import QC.GetSuixintieSigFontRsp;
import QC.UniBusiSimpleItemDetail;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.api.IJce;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes16.dex */
public class StickyNoteShopLayout extends FrameLayout implements View.OnClickListener {
    public static final String E = BaseApplication.getContext().getFilesDir().getAbsolutePath() + File.separator + "sticky_list_cache";
    private int C;
    private RecyclerView.OnScrollListener D;

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f260281d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.profile.stickynote.vas.a f260282e;

    /* renamed from: f, reason: collision with root package name */
    private int f260283f;

    /* renamed from: h, reason: collision with root package name */
    private String f260284h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f260285i;

    /* renamed from: m, reason: collision with root package name */
    public int f260286m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            int i16;
            if (i3 == 0) {
                RecyclerView.LayoutManager layoutManager = StickyNoteShopLayout.this.f260281d.getLayoutManager();
                if (layoutManager instanceof StaggeredGridLayoutManager) {
                    StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                    i16 = StickyNoteShopLayout.this.h(staggeredGridLayoutManager.findLastVisibleItemPositions(new int[staggeredGridLayoutManager.getSpanCount()]));
                } else {
                    i16 = 0;
                }
                if (layoutManager.getChildCount() > 0 && i16 >= layoutManager.getItemCount() - 1) {
                    StickyNoteShopLayout.this.m(true);
                    QLog.d("StickyNoteShopLayout", 2, " load more shop data newState:" + i3 + " lastVisiblePosition:" + i16);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface b {
        void i6(int i3, int i16);

        void oe(int i3, int i16);
    }

    public StickyNoteShopLayout(@NonNull Context context) {
        super(context);
        this.f260284h = "";
        this.f260285i = false;
        this.f260286m = 2;
        this.C = 0;
        this.D = new a();
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(int[] iArr) {
        int i3 = iArr[0];
        for (int i16 : iArr) {
            if (i16 > i3) {
                i3 = i16;
            }
        }
        return i3;
    }

    private void k() {
        View.inflate(getContext(), R.layout.bn6, this);
        this.f260281d = (RecyclerView) findViewById(R.id.f166916is1);
        this.f260281d.setLayoutManager(new StaggeredGridLayoutManager(3, 1));
        com.tencent.mobileqq.profile.stickynote.vas.a aVar = new com.tencent.mobileqq.profile.stickynote.vas.a(getContext(), null);
        this.f260282e = aVar;
        aVar.O(this);
        this.f260281d.setAdapter(this.f260282e);
        this.f260281d.setOnScrollListener(this.D);
        this.f260281d.setBackgroundColor(-1);
        findViewById(R.id.mca).setOnClickListener(this);
        findViewById(R.id.f165763fq0).setOnClickListener(this);
        l();
    }

    public int g(int i3) {
        int i16 = ScreenUtil.SCREEN_HIGHT;
        if (i3 <= i16 / 4) {
            i3 = i16 / 3;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i3;
        setMinimumHeight(i3);
        setLayoutParams(layoutParams);
        return i3;
    }

    public com.tencent.mobileqq.profile.stickynote.vas.a i() {
        return this.f260282e;
    }

    public void j() {
        setVisibility(8);
        g(0);
    }

    public void l() {
        this.f260281d.setAdapter(this.f260282e);
    }

    public void m(final boolean z16) {
        String str;
        QLog.d("StickyNoteShopLayout", 2, " appId:" + this.f260283f + " mIsLoadLast:" + this.f260285i + " isLoadMore:" + z16 + " mStrAttachInfo:" + this.f260284h);
        if (this.f260285i) {
            return;
        }
        if (this.f260286m == 2 && this.f260282e.C() >= 30 && z16) {
            return;
        }
        IJce build = VasUtil.getService().getJceRequset().build("QC.HomepageLogicServer.HomepageLogicObj", "QcHomePageLogic.GetSuixintieSigFontReq");
        GetSuixintieSigFontReq getSuixintieSigFontReq = new GetSuixintieSigFontReq(IJce.Util.getLoginInfo(), this.f260283f, this.C, "", this.f260284h);
        if (this.f260286m == 1) {
            str = "getSuixintieSigFont";
        } else {
            str = "getExtendFriendSigFont";
        }
        build.request(str, getSuixintieSigFontReq, new GetSuixintieSigFontRsp(), new BusinessObserver() { // from class: com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout.1
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public void onUpdate(int i3, boolean z17, Object obj) {
                ArrayList<UniBusiSimpleItemDetail> arrayList;
                if (obj instanceof GetSuixintieSigFontRsp) {
                    final GetSuixintieSigFontRsp getSuixintieSigFontRsp = (GetSuixintieSigFontRsp) obj;
                    if (getSuixintieSigFontRsp.isEnd == 1 && getSuixintieSigFontRsp.vItems.size() == 1) {
                        return;
                    }
                    if (!z16) {
                        FileUtils.writeFile(getSuixintieSigFontRsp.toByteArray(), StickyNoteShopLayout.E + util.base64_pad_url + StickyNoteShopLayout.this.f260283f);
                    }
                    QLog.d("StickyNoteShopLayout", 2, " type:" + i3 + " isSuccess:" + z17 + " isLoadMore:" + z16 + " size:" + getSuixintieSigFontRsp.stRet.ret);
                    StickyNoteShopLayout.this.f260284h = getSuixintieSigFontRsp.strAttachInfo;
                    if (getSuixintieSigFontRsp.stRet.ret != 0 || (arrayList = getSuixintieSigFontRsp.vItems) == null || arrayList.size() <= 0) {
                        StickyNoteShopLayout.this.f260285i = true;
                        return;
                    } else {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                StickyNoteShopLayout.this.findViewById(R.id.mca).setVisibility(8);
                                StickyNoteShopLayout.this.findViewById(R.id.f165763fq0).setVisibility(8);
                                StickyNoteShopLayout.this.f260282e.Q(getSuixintieSigFontRsp.vItems, z16);
                            }
                        });
                        return;
                    }
                }
                if (!z16 && StickyNoteShopLayout.this.f260282e.getItemCount() == 0) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            StickyNoteShopLayout.this.findViewById(R.id.mca).setVisibility(0);
                            StickyNoteShopLayout.this.findViewById(R.id.f165763fq0).setVisibility(0);
                        }
                    });
                }
            }
        }, false);
        if (!z16) {
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    byte[] readFile = FileUtils.readFile(StickyNoteShopLayout.E + util.base64_pad_url + StickyNoteShopLayout.this.f260283f);
                    if (readFile != null) {
                        final GetSuixintieSigFontRsp getSuixintieSigFontRsp = new GetSuixintieSigFontRsp();
                        getSuixintieSigFontRsp.readFrom(new JceInputStream(readFile));
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                StickyNoteShopLayout.this.findViewById(R.id.mca).setVisibility(8);
                                StickyNoteShopLayout.this.findViewById(R.id.f165763fq0).setVisibility(8);
                                StickyNoteShopLayout.this.f260282e.Q(getSuixintieSigFontRsp.vItems, false);
                            }
                        });
                    }
                }
            });
        }
    }

    public void n(int i3, int i16, Intent intent) {
        this.f260282e.H();
    }

    public void o(int i3) {
        setVisibility(i3);
        if (this.f260282e.getItemCount() == 0) {
            m(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.mca) {
            m(false);
        } else if (id5 == R.id.f165763fq0) {
            m(false);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setAppId(int i3) {
        this.f260283f = i3;
        com.tencent.mobileqq.profile.stickynote.vas.a aVar = this.f260282e;
        if (aVar != null) {
            aVar.L(i3);
        }
    }

    public void setItemId(int i3) {
        this.f260282e.M(i3);
    }

    public void setShopCallback(b bVar) {
        this.f260282e.N(bVar);
    }

    public void setUseId(int i3) {
        this.f260286m = i3;
    }

    public void setUsingItem(int i3) {
        this.C = i3;
    }

    public StickyNoteShopLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f260284h = "";
        this.f260285i = false;
        this.f260286m = 2;
        this.C = 0;
        this.D = new a();
        k();
    }

    public StickyNoteShopLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f260284h = "";
        this.f260285i = false;
        this.f260286m = 2;
        this.C = 0;
        this.D = new a();
        k();
    }
}
