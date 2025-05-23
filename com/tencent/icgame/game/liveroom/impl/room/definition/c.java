package com.tencent.icgame.game.liveroom.impl.room.definition;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.icgame.data.room.EnterRoomInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f115205a;

    /* renamed from: b, reason: collision with root package name */
    private ViewGroup f115206b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f115207c = false;

    /* renamed from: d, reason: collision with root package name */
    private List<EnterRoomInfo.VideoDefinition> f115208d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private d f115209e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class a implements Comparator<EnterRoomInfo.VideoDefinition> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(EnterRoomInfo.VideoDefinition videoDefinition, EnterRoomInfo.VideoDefinition videoDefinition2) {
            if (c.this.f115207c) {
                if (videoDefinition.level < videoDefinition2.level) {
                    return 1;
                }
                return -1;
            }
            if (videoDefinition.level > videoDefinition2.level) {
                return 1;
            }
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            c.this.r((EnterRoomInfo.VideoDefinition) view.getTag());
            QLog.i("ICGameAudienceDefinitionView", 1, " selectDefinition: " + view.getTag());
            if (c.this.f115209e != null) {
                c.this.f115209e.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.icgame.game.liveroom.impl.room.definition.c$c, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C5833c {

        /* renamed from: a, reason: collision with root package name */
        private c f115212a;

        /* renamed from: b, reason: collision with root package name */
        private d f115213b;

        /* renamed from: c, reason: collision with root package name */
        private List<EnterRoomInfo.VideoDefinition> f115214c;

        /* renamed from: d, reason: collision with root package name */
        private Activity f115215d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f115216e = false;

        public c a() {
            c cVar = new c(this.f115215d);
            this.f115212a = cVar;
            cVar.k(this.f115214c);
            this.f115212a.m(this.f115213b);
            this.f115212a.l(this.f115216e);
            this.f115212a.g();
            return this.f115212a;
        }

        public C5833c b(Activity activity) {
            this.f115215d = activity;
            return this;
        }

        public C5833c c(@NonNull List<EnterRoomInfo.VideoDefinition> list) {
            this.f115214c = list;
            return this;
        }

        public C5833c d(boolean z16) {
            this.f115216e = z16;
            return this;
        }

        public C5833c e(d dVar) {
            this.f115213b = dVar;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface d {
        void onClick(View view);
    }

    c(Activity activity) {
        this.f115205a = activity;
    }

    private TextView f(EnterRoomInfo.VideoDefinition videoDefinition) {
        LinearLayout.LayoutParams layoutParams;
        TextView textView = new TextView(this.f115205a);
        textView.setTextSize(16.0f);
        textView.setText(com.tencent.icgame.game.liveroom.impl.room.definition.b.e(videoDefinition));
        textView.setTextColor(this.f115205a.getResources().getColor(R.color.bxe));
        textView.setVisibility(0);
        textView.setTag(videoDefinition);
        if (this.f115207c) {
            textView.setGravity(8388629);
        } else {
            textView.setGravity(81);
        }
        textView.setOnClickListener(new b());
        if (this.f115207c) {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
        } else {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
        }
        layoutParams.weight = 1.0f;
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewGroup g() {
        List<EnterRoomInfo.VideoDefinition> list = this.f115208d;
        if (list != null && !list.isEmpty()) {
            ViewGroup h16 = h(this.f115205a);
            LinearLayout linearLayout = (LinearLayout) h16.findViewById(R.id.uft);
            Iterator<EnterRoomInfo.VideoDefinition> it = n(this.f115208d).iterator();
            while (it.hasNext()) {
                linearLayout.addView(f(it.next()));
            }
            this.f115206b = h16;
            return h16;
        }
        QLog.w("ICGameAudienceDefinitionView", 1, "createView definitionList is empty");
        return null;
    }

    private ViewGroup h(Context context) {
        if (this.f115207c) {
            return (ViewGroup) View.inflate(context, R.layout.fbr, null);
        }
        return (ViewGroup) View.inflate(context, R.layout.fbq, null);
    }

    private Drawable i() {
        Resources resources = this.f115205a.getResources();
        if (this.f115207c) {
            return resources.getDrawable(R.drawable.o8g);
        }
        return resources.getDrawable(R.drawable.o8f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(@NonNull List<EnterRoomInfo.VideoDefinition> list) {
        this.f115208d = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(d dVar) {
        this.f115209e = dVar;
    }

    private List<EnterRoomInfo.VideoDefinition> n(@NonNull List<EnterRoomInfo.VideoDefinition> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList, new a());
        return arrayList;
    }

    private void o(EnterRoomInfo.VideoDefinition videoDefinition) {
        ViewGroup viewGroup = this.f115206b;
        if (viewGroup == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(R.id.uft);
        for (int i3 = 0; i3 < linearLayout.getChildCount(); i3++) {
            TextView textView = (TextView) linearLayout.getChildAt(i3);
            if (videoDefinition == ((EnterRoomInfo.VideoDefinition) textView.getTag())) {
                p(textView);
            } else {
                q(textView);
            }
        }
    }

    private void p(TextView textView) {
        textView.setTextColor(this.f115205a.getResources().getColor(R.color.bxd));
        textView.setTypeface(Typeface.defaultFromStyle(1));
        Drawable i3 = i();
        if (this.f115207c) {
            textView.setCompoundDrawablesWithIntrinsicBounds(i3, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setCompoundDrawablePadding(4);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, i3, (Drawable) null, (Drawable) null);
            textView.setCompoundDrawablePadding(2);
        }
        textView.setEnabled(false);
    }

    private void q(TextView textView) {
        textView.setTextColor(this.f115205a.getResources().getColor(R.color.bxe));
        textView.setTypeface(Typeface.defaultFromStyle(0));
        textView.setCompoundDrawables(null, null, null, null);
        textView.setEnabled(true);
    }

    public ViewGroup j() {
        return this.f115206b;
    }

    public void l(boolean z16) {
        this.f115207c = z16;
    }

    public void r(EnterRoomInfo.VideoDefinition videoDefinition) {
        QLog.i("ICGameAudienceDefinitionView", 1, " selectDefinition:" + videoDefinition);
        o(videoDefinition);
    }
}
