package com.tencent.mobileqq.wink.editor.templatecoll;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.picker.TemplateLibraryHolderInfo;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.wink.picker.event.WinkCircleShowPhotoPreviewEvent;
import com.tencent.mobileqq.wink.view.RoundCorneredRelativeLayout;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public class f extends com.tencent.mobileqq.wink.editor.templatecoll.b {
    private ArrayList<b> C;
    private int D;
    private a G;
    private boolean H;

    /* renamed from: e, reason: collision with root package name */
    private LayoutInflater f322504e;

    /* renamed from: f, reason: collision with root package name */
    private HashMap<String, LocalMediaInfo> f322505f;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<TemplateLibraryHolderInfo> f322506h;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<LocalMediaInfo> f322507i;

    /* renamed from: m, reason: collision with root package name */
    private int f322508m;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<String> f322503d = new ArrayList<>();
    private int E = -1;
    private boolean F = false;
    private HashMap<LocalMediaInfo, Bitmap> I = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface a {
        void a(int i3, LocalMediaInfo localMediaInfo);
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public String f322509a;

        /* renamed from: b, reason: collision with root package name */
        public URLDrawable f322510b;

        public b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
        private View C;
        private View D;
        private FrameLayout E;

        /* renamed from: d, reason: collision with root package name */
        public TextView f322512d;

        /* renamed from: e, reason: collision with root package name */
        private URLImageView f322513e;

        /* renamed from: f, reason: collision with root package name */
        public ImageView f322514f;

        /* renamed from: h, reason: collision with root package name */
        public RoundCorneredRelativeLayout f322515h;

        /* renamed from: i, reason: collision with root package name */
        public TextView f322516i;

        /* renamed from: m, reason: collision with root package name */
        public RelativeLayout f322517m;

        public c(View view) {
            super(view);
            this.f322513e = (URLImageView) view.findViewById(R.id.dwp);
            this.f322514f = (ImageView) view.findViewById(R.id.f165918y20);
            this.C = view.findViewById(R.id.f165919y21);
            this.f322512d = (TextView) view.findViewById(R.id.f107586at);
            this.f322515h = (RoundCorneredRelativeLayout) view.findViewById(R.id.f70603lw);
            this.f322516i = (TextView) view.findViewById(R.id.y9t);
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.y6s);
            this.f322517m = relativeLayout;
            relativeLayout.setOnClickListener(this);
            this.D = view.findViewById(R.id.f115956xf);
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.v7d);
            this.E = frameLayout;
            frameLayout.setOnClickListener(this);
            this.C.setOnClickListener(this);
            float dip2px = ViewUtils.dip2px(4.0f);
            this.f322515h.setRadius(dip2px, dip2px, dip2px, dip2px);
            if (f.this.D == 101) {
                this.f322516i.setVisibility(8);
            }
            if (f.this.F) {
                this.f322514f.setVisibility(4);
                this.f322515h.setBackgroundColor(0);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar;
            EventCollector.getInstance().onViewClickedBefore(view);
            int adapterPosition = getAdapterPosition();
            if (adapterPosition >= 0 && f.this.C.size() > adapterPosition && f.this.f322506h.size() > adapterPosition && (bVar = (b) f.this.C.get(adapterPosition)) != null && !TextUtils.isEmpty(bVar.f322509a)) {
                if (view == this.C && !f.this.F) {
                    f.this.y(bVar.f322509a, adapterPosition);
                } else if (view == this.f322517m && !f.this.F) {
                    if (f.this.f322505f != null && f.this.f322505f.size() >= 1) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add((LocalMediaInfo) f.this.f322505f.get(bVar.f322509a));
                        SimpleEventBus.getInstance().dispatchEvent(new WinkCircleShowPhotoPreviewEvent(arrayList, 0, true, false));
                    }
                }
                if (f.this.G != null) {
                    f.this.G.a(adapterPosition, (LocalMediaInfo) f.this.f322505f.get(bVar.f322509a));
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public f(@NonNull Context context, HashMap<String, LocalMediaInfo> hashMap, int i3, ArrayList<TemplateLibraryHolderInfo> arrayList, ArrayList<LocalMediaInfo> arrayList2, boolean z16) {
        this.f322504e = LayoutInflater.from(context);
        this.D = i3;
        this.f322506h = arrayList;
        this.f322505f = hashMap;
        this.f322507i = arrayList2;
        this.H = z16;
    }

    private void C(FrameLayout frameLayout, LocalMediaInfo localMediaInfo) {
        VideoReport.setElementId(frameLayout, WinkDaTongReportConstant.ElementId.EM_XSJ_OPENING_ENDING_EDIT_CLIP_BUTTON);
        VideoReport.setElementReuseIdentifier(frameLayout, String.valueOf(localMediaInfo.hashCode()));
        VideoReport.setElementParams(frameLayout, WinkDTParamBuilder.buildElementParams());
        VideoReport.setElementEndExposePolicy(frameLayout, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(frameLayout, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(frameLayout, ExposurePolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(LocalMediaInfo localMediaInfo, Bitmap bitmap, int i3) {
        this.I.put(localMediaInfo, bitmap);
        notifyItemChanged(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(final LocalMediaInfo localMediaInfo, final int i3) {
        if (localMediaInfo == null) {
            return;
        }
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(localMediaInfo.path);
            final Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(localMediaInfo.mStartTime * 1000, 2);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.D(localMediaInfo, frameAtTime, i3);
                }
            });
        } catch (Exception e16) {
            w53.b.c("TemplatePicMoveAdapter", "updateVideoThumbnailAsync failed: " + e16);
        }
    }

    private void H(String str, int i3) {
        if (this.f322503d == null) {
            return;
        }
        HashMap<String, LocalMediaInfo> hashMap = this.f322505f;
        if (hashMap != null) {
            LocalMediaInfo localMediaInfo = hashMap.get(str);
            if (localMediaInfo != null) {
                localMediaInfo.selectStatus = 2;
            }
            if (localMediaInfo != null && !this.f322503d.contains(localMediaInfo.path)) {
                this.f322505f.remove(localMediaInfo.path);
            }
        }
        int B = B(i3, str);
        if (B == 0) {
            this.f322503d.remove(str);
        } else {
            int i16 = 0;
            while (true) {
                if (i16 < this.f322503d.size()) {
                    if (this.f322503d.get(i16).equals(str) && B - 1 == 0) {
                        this.f322503d.remove(i16);
                        break;
                    }
                    i16++;
                } else {
                    break;
                }
            }
        }
        this.C.set(i3, new b());
        notifyItemRemoved(i3);
        notifyItemRangeChanged(i3, getItemCount() - i3);
    }

    private void M(c cVar, boolean z16, LocalMediaInfo localMediaInfo) {
        int i3;
        int i16;
        FrameLayout frameLayout = cVar.E;
        int i17 = 0;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        frameLayout.setVisibility(i3);
        View view = cVar.D;
        if (z16) {
            i16 = 8;
        } else {
            i16 = 0;
        }
        view.setVisibility(i16);
        TextView textView = cVar.f322512d;
        if (z16) {
            i17 = 8;
        }
        textView.setVisibility(i17);
        if (this.H) {
            C(cVar.E, localMediaInfo);
        }
    }

    private void N(LocalMediaInfo localMediaInfo, c cVar) {
        if (localMediaInfo != null) {
            cVar.f322517m.setVisibility(0);
            ViewExKt.n(cVar.f322513e, localMediaInfo);
        }
    }

    private void O(final int i3, final LocalMediaInfo localMediaInfo) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.d
            @Override // java.lang.Runnable
            public final void run() {
                f.this.E(localMediaInfo, i3);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, int i3) {
        H(str, i3);
        this.f322503d.size();
        throw null;
    }

    private void z(View view, String str) {
        String str2;
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_VIDEO_COVER);
        VideoReport.setElementReuseIdentifier(view, str);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        if (this.F) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_TEMPLATE_PAGE, str2);
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, WinkDatongCurrentParams.params.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID));
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    public int A() {
        for (int i3 = 0; i3 < this.C.size(); i3++) {
            if (TextUtils.isEmpty(this.C.get(i3).f322509a)) {
                return i3;
            }
        }
        return -1;
    }

    public int B(int i3, String str) {
        if (this.C.size() <= i3) {
            return 0;
        }
        int i16 = 0;
        for (int i17 = 0; i17 <= i3; i17++) {
            String str2 = this.C.get(i17).f322509a;
            if (!TextUtils.isEmpty(str2) && str2.equals(str)) {
                i16++;
            }
        }
        return i16;
    }

    public void F(ArrayList<String> arrayList) {
        if (A() != -1) {
            b bVar = new b();
            bVar.f322509a = arrayList.get(arrayList.size() - 1);
            this.C.set(A(), bVar);
        } else {
            G(arrayList);
        }
        arrayList.size();
    }

    public void G(ArrayList<String> arrayList) {
        this.C.clear();
        for (int i3 = 0; i3 < this.f322508m; i3++) {
            b bVar = new b();
            if (i3 < arrayList.size()) {
                bVar.f322509a = arrayList.get(i3);
            }
            this.C.add(bVar);
        }
    }

    public void I(a aVar) {
        this.G = aVar;
    }

    public void J(ArrayList<String> arrayList, int i3) {
        if (arrayList != null) {
            this.f322503d = arrayList;
        }
        this.f322508m = i3;
        this.C = new ArrayList<>(this.f322508m);
        notifyDataSetChanged();
    }

    public void K(boolean z16) {
        this.F = z16;
    }

    public int L(float f16) {
        Iterator<TemplateLibraryHolderInfo> it = this.f322506h.iterator();
        float f17 = 0.0f;
        int i3 = 0;
        while (it.hasNext()) {
            TemplateLibraryHolderInfo next = it.next();
            if (next != null) {
                f17 += next.getHolderTimeSlot();
                if (f17 > f16) {
                    if (this.E != i3) {
                        this.E = i3;
                        notifyDataSetChanged();
                    }
                    return i3;
                }
                i3++;
            }
        }
        return -1;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.C.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3, List<Object> list) {
        if (list.isEmpty()) {
            onBindViewHolder(viewHolder, i3);
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, list, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new c(this.f322504e.inflate(R.layout.i7x, viewGroup, false));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0089  */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        String str;
        int mediaType;
        c cVar = (c) viewHolder;
        if (this.C.size() > i3 && this.C.get(i3) != null) {
            b bVar = this.C.get(i3);
            LocalMediaInfo localMediaInfo = this.f322505f.get(bVar.f322509a);
            if (i3 < this.f322506h.size()) {
                float holderTimeSlot = this.f322506h.get(i3).getHolderTimeSlot();
                if (holderTimeSlot > 0.0f) {
                    str = String.format(Locale.CHINA, "%.1f", Float.valueOf(holderTimeSlot)) + ReportConstant.COSTREPORT_PREFIX;
                    URL url = null;
                    if (localMediaInfo != null) {
                        cVar.f322513e.setImageBitmap(null);
                        cVar.f322517m.setVisibility(4);
                        cVar.f322516i.setVisibility(0);
                        cVar.f322516i.setText(str);
                        cVar.f322512d.setVisibility(4);
                    } else {
                        cVar.f322516i.setVisibility(4);
                        cVar.f322512d.setVisibility(0);
                        cVar.f322512d.setText(str);
                    }
                    if (i3 != A()) {
                        cVar.f322515h.setForeground(R.drawable.l6a);
                    } else if (i3 == this.E) {
                        cVar.f322515h.setForeground(R.drawable.on_);
                        M(cVar, true, localMediaInfo);
                    } else {
                        cVar.f322515h.setForeground(-1);
                        M(cVar, false, localMediaInfo);
                    }
                    mediaType = QAlbumUtil.getMediaType(localMediaInfo);
                    if (mediaType != 0) {
                        N(localMediaInfo, cVar);
                    } else if (mediaType == 1) {
                        if (this.H) {
                            LocalMediaInfo localMediaInfo2 = this.f322507i.get(i3);
                            Bitmap bitmap = this.I.get(localMediaInfo2);
                            if (bitmap != null) {
                                cVar.f322513e.setImageBitmap(bitmap);
                                cVar.f322517m.setVisibility(0);
                            } else {
                                O(i3, localMediaInfo2);
                            }
                        } else {
                            if (localMediaInfo != null) {
                                if (localMediaInfo.isSystemMeidaStore) {
                                    url = QAlbumUtil.generateAlbumThumbURL(localMediaInfo, "VIDEO");
                                } else {
                                    url = QAlbumUtil.generateAlbumThumbURL(localMediaInfo, "APP_VIDEO");
                                }
                            }
                            if (localMediaInfo != null) {
                                int i16 = AlbumThumbDownloader.THUMB_WIDHT;
                                localMediaInfo.thumbHeight = i16;
                                localMediaInfo.thumbWidth = i16;
                            }
                            URLDrawable uRLDrawable = this.C.get(i3).f322510b;
                            if (uRLDrawable != null) {
                                cVar.f322513e.setImageDrawable(uRLDrawable);
                            } else {
                                URLDrawable drawable = com.tencent.mobileqq.wink.utils.aa.getDrawable(url);
                                drawable.setTag(localMediaInfo);
                                cVar.f322513e.setImageDrawable(drawable);
                                this.C.get(i3).f322510b = drawable;
                            }
                            cVar.f322517m.setVisibility(0);
                        }
                    }
                    z(viewHolder.itemView, bVar.f322509a);
                }
            }
            str = "";
            URL url2 = null;
            if (localMediaInfo != null) {
            }
            if (i3 != A()) {
            }
            mediaType = QAlbumUtil.getMediaType(localMediaInfo);
            if (mediaType != 0) {
            }
            z(viewHolder.itemView, bVar.f322509a);
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
    }
}
