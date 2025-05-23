package com.tencent.mobileqq.colornote.list;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.colornote.anim.MusicDanceDrawable;
import com.tencent.mobileqq.colornote.api.impl.ColorNoteControllerImpl;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteRecentConfigProcessor;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.colornote.smallscreen.UpComingMsgModel;
import com.tencent.mobileqq.music.api.IQQPlayer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.vas.api.IVasAudioApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends RecyclerView.Adapter<d> {

    /* renamed from: d, reason: collision with root package name */
    private List<ColorNote> f201478d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f201479e;

    /* renamed from: f, reason: collision with root package name */
    private h f201480f;

    /* renamed from: h, reason: collision with root package name */
    private c f201481h;

    /* renamed from: i, reason: collision with root package name */
    private List<f> f201482i;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.colornote.list.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static class ViewOnClickListenerC7456a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        a f201483d;

        /* renamed from: e, reason: collision with root package name */
        d f201484e;

        ViewOnClickListenerC7456a(a aVar, d dVar) {
            this.f201483d = aVar;
            this.f201484e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            int adapterPosition = this.f201484e.getAdapterPosition();
            if (adapterPosition >= 0 && adapterPosition < this.f201483d.f201478d.size()) {
                ColorNote colorNote = (ColorNote) this.f201483d.f201478d.get(adapterPosition);
                this.f201483d.f201478d.remove(adapterPosition);
                this.f201483d.notifyDataSetChanged();
                int serviceType = colorNote.getServiceType();
                if (serviceType != 16973824) {
                    if (serviceType == 17367040) {
                        ((IVasAudioApi) QRoute.api(IVasAudioApi.class)).pause("");
                    }
                } else {
                    ((IQQPlayer) QRoute.api(IQQPlayer.class)).stopPlayMusic(view.getContext());
                }
                if (com.tencent.mobileqq.colornote.data.a.w(colorNote)) {
                    if (ColorNoteRecentConfigProcessor.a().a() && com.tencent.mobileqq.colornote.e.c()) {
                        this.f201483d.f201481h.a(view);
                    }
                } else {
                    ReportController.o(null, "dc00898", "", "", "0X800A747", "0X800A747", com.tencent.mobileqq.colornote.a.b(colorNote.getServiceType()), 0, "", "", "", "");
                }
                if (this.f201483d.getItemCount() == 0 && this.f201483d.f201480f != null) {
                    this.f201483d.f201480f.a();
                }
                this.f201483d.w(view, colorNote);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        a f201485d;

        /* renamed from: e, reason: collision with root package name */
        d f201486e;

        b(a aVar, d dVar) {
            this.f201485d = aVar;
            this.f201486e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ColorNote colorNote = (ColorNote) this.f201485d.f201478d.get(this.f201486e.getAdapterPosition());
            ColorNoteControllerImpl.launch(view.getContext(), colorNote);
            if (this.f201485d.f201480f != null) {
                this.f201485d.f201480f.a();
            }
            this.f201485d.v(view, colorNote);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface c {
        void a(View view);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class d extends RecyclerView.ViewHolder implements View.OnClickListener {
        public Button C;
        public ImageView D;
        ViewOnClickListenerC7456a E;
        Drawable F;

        /* renamed from: d, reason: collision with root package name */
        a f201487d;

        /* renamed from: e, reason: collision with root package name */
        public View f201488e;

        /* renamed from: f, reason: collision with root package name */
        public View f201489f;

        /* renamed from: h, reason: collision with root package name */
        public ImageView f201490h;

        /* renamed from: i, reason: collision with root package name */
        public TextView f201491i;

        /* renamed from: m, reason: collision with root package name */
        public TextView f201492m;

        public d(a aVar, View view) {
            super(view);
            int i3;
            this.f201487d = aVar;
            Resources resources = view.getContext().getResources();
            view.setOnClickListener(this);
            View findViewById = view.findViewById(R.id.lxz);
            AccessibilityUtil.n(findViewById, false);
            findViewById.setOnClickListener(this);
            View findViewById2 = view.findViewById(R.id.f166422ly0);
            AccessibilityUtil.n(findViewById2, false);
            findViewById2.setOnClickListener(this);
            if (aVar.f201479e) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            findViewById.setVisibility(i3);
            findViewById2.setVisibility(aVar.f201479e ? 0 : 8);
            View findViewById3 = view.findViewById(R.id.lxv);
            this.f201488e = findViewById3;
            findViewById3.setContentDescription(resources.getString(R.string.imi));
            this.f201489f = view.findViewById(R.id.lxs);
            this.f201490h = (ImageView) view.findViewById(R.id.lxw);
            TextView textView = (TextView) view.findViewById(R.id.f166424ly2);
            this.f201491i = textView;
            textView.setCompoundDrawablePadding(Utils.n(3.0f, resources));
            this.f201491i.setFocusable(true);
            this.f201491i.setFocusableInTouchMode(true);
            this.D = (ImageView) view.findViewById(R.id.zsl);
            AccessibilityUtil.n(this.f201491i, true);
            TextView textView2 = (TextView) view.findViewById(R.id.f166423ly1);
            this.f201492m = textView2;
            textView2.setFocusable(true);
            this.f201492m.setFocusableInTouchMode(true);
            AccessibilityUtil.n(this.f201492m, true);
            this.C = (Button) view.findViewById(R.id.lxx);
            ViewOnClickListenerC7456a viewOnClickListenerC7456a = new ViewOnClickListenerC7456a(aVar, this);
            this.E = viewOnClickListenerC7456a;
            this.C.setOnClickListener(viewOnClickListenerC7456a);
            this.f201488e.setOnClickListener(new b(aVar, this));
            MusicDanceDrawable musicDanceDrawable = new MusicDanceDrawable();
            this.F = musicDanceDrawable;
            musicDanceDrawable.b(view.getContext(), Utils.n(15.0f, resources), Utils.n(9.5f, resources));
        }

        public ColorNote b(int i3) {
            return (ColorNote) this.f201487d.f201478d.get(i3);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            int id5 = view.getId();
            if ((id5 == R.id.lxz || id5 == R.id.f166422ly0) && this.f201487d.f201480f != null) {
                this.f201487d.f201480f.a();
                ReportController.o(null, "dc00898", "", "", "0X800A6CE", "0X800A6CE", 0, 0, "", "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public a(List<f> list) {
        this.f201482i = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(View view, ColorNote colorNote) {
        Iterator<f> it = this.f201482i.iterator();
        while (it.hasNext()) {
            it.next().c(view, colorNote);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(View view, ColorNote colorNote) {
        Iterator<f> it = this.f201482i.iterator();
        while (it.hasNext()) {
            it.next().a(view, colorNote);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(List<ColorNote> list) {
        this.f201478d = list;
    }

    public void B(h hVar) {
        this.f201480f = hVar;
    }

    public void C(c cVar) {
        this.f201481h = cVar;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<ColorNote> list = this.f201478d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(d dVar, int i3) {
        int i16;
        ColorNote colorNote = this.f201478d.get(i3);
        ColorNoteControllerImpl.getItemBuilder(colorNote).b(dVar, i3, this.f201479e);
        if (com.tencent.mobileqq.colornote.data.a.x(colorNote)) {
            UpComingMsgModel e16 = ColorNoteSmallScreenUtil.e(colorNote);
            int c16 = x.c(dVar.f201491i.getContext(), 200.0f);
            if (com.tencent.mobileqq.colornote.data.a.u(colorNote)) {
                i16 = x.c(dVar.f201491i.getContext(), 27.0f);
            } else {
                i16 = 0;
            }
            int i17 = i16;
            if (e16.uniseq.size() > 1) {
                dVar.f201491i.setMaxWidth(c16);
                ColorNoteSmallScreenUtil.a(dVar.f201491i, colorNote.getMainTitle(), c16, TextUtils.TruncateAt.MIDDLE, "\u7684", i17);
            } else {
                ColorNoteSmallScreenUtil.a(dVar.f201491i, colorNote.getMainTitle(), c16, TextUtils.TruncateAt.END, null, i17);
            }
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(dVar, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public d onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new d(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c7l, viewGroup, false));
    }

    public void z(boolean z16) {
        this.f201479e = z16;
    }
}
