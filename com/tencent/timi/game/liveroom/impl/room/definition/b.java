package com.tencent.timi.game.liveroom.impl.room.definition;

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
import com.tencent.mobileqq.qqlive.data.room.EnterRoomInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f377541a;

    /* renamed from: b, reason: collision with root package name */
    private ViewGroup f377542b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f377543c = false;

    /* renamed from: d, reason: collision with root package name */
    private List<EnterRoomInfo.VideoDefinition> f377544d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private e f377545e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements Comparator<EnterRoomInfo.VideoDefinition> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(EnterRoomInfo.VideoDefinition videoDefinition, EnterRoomInfo.VideoDefinition videoDefinition2) {
            if (b.this.f377543c) {
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
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.definition.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class ViewOnClickListenerC9935b implements View.OnClickListener {
        ViewOnClickListenerC9935b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            b.this.s((EnterRoomInfo.VideoDefinition) view.getTag());
            QLog.i("AudienceDefinitionView", 1, " selectDefinition: " + view.getTag());
            if (b.this.f377545e != null) {
                b.this.f377545e.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f377548a;

        static {
            int[] iArr = new int[EnterRoomInfo.VideoDefinition.values().length];
            f377548a = iArr;
            try {
                iArr[EnterRoomInfo.VideoDefinition.ORIGIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f377548a[EnterRoomInfo.VideoDefinition.FHD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f377548a[EnterRoomInfo.VideoDefinition.SD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f377548a[EnterRoomInfo.VideoDefinition.HD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f377548a[EnterRoomInfo.VideoDefinition.SHD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f377548a[EnterRoomInfo.VideoDefinition.THFD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private b f377549a;

        /* renamed from: b, reason: collision with root package name */
        private e f377550b;

        /* renamed from: c, reason: collision with root package name */
        private List<EnterRoomInfo.VideoDefinition> f377551c;

        /* renamed from: d, reason: collision with root package name */
        private Activity f377552d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f377553e = false;

        public b a() {
            b bVar = new b(this.f377552d);
            this.f377549a = bVar;
            bVar.l(this.f377551c);
            this.f377549a.n(this.f377550b);
            this.f377549a.m(this.f377553e);
            this.f377549a.g();
            return this.f377549a;
        }

        public d b(Activity activity) {
            this.f377552d = activity;
            return this;
        }

        public d c(@NonNull List<EnterRoomInfo.VideoDefinition> list) {
            this.f377551c = list;
            return this;
        }

        public d d(boolean z16) {
            this.f377553e = z16;
            return this;
        }

        public d e(e eVar) {
            this.f377550b = eVar;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface e {
        void onClick(View view);
    }

    b(Activity activity) {
        this.f377541a = activity;
    }

    private TextView f(EnterRoomInfo.VideoDefinition videoDefinition) {
        LinearLayout.LayoutParams layoutParams;
        TextView textView = new TextView(this.f377541a);
        textView.setTextSize(16.0f);
        textView.setText(i(videoDefinition));
        textView.setTextColor(this.f377541a.getResources().getColor(R.color.bxe));
        textView.setVisibility(0);
        textView.setTag(videoDefinition);
        if (this.f377543c) {
            textView.setGravity(8388629);
        } else {
            textView.setGravity(81);
        }
        textView.setOnClickListener(new ViewOnClickListenerC9935b());
        if (this.f377543c) {
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
        List<EnterRoomInfo.VideoDefinition> list = this.f377544d;
        if (list != null && !list.isEmpty()) {
            ViewGroup h16 = h(this.f377541a);
            LinearLayout linearLayout = (LinearLayout) h16.findViewById(R.id.uft);
            Iterator<EnterRoomInfo.VideoDefinition> it = o(this.f377544d).iterator();
            while (it.hasNext()) {
                linearLayout.addView(f(it.next()));
            }
            this.f377542b = h16;
            return h16;
        }
        QLog.w("AudienceDefinitionView", 1, "createView definitionList is empty");
        return null;
    }

    private ViewGroup h(Context context) {
        if (this.f377543c) {
            return (ViewGroup) View.inflate(context, R.layout.huj, null);
        }
        return (ViewGroup) View.inflate(context, R.layout.hui, null);
    }

    private String i(EnterRoomInfo.VideoDefinition videoDefinition) {
        switch (c.f377548a[videoDefinition.ordinal()]) {
            case 1:
            case 2:
                return "\u84dd\u5149";
            case 3:
                return "\u6807\u6e05";
            case 4:
                return "\u9ad8\u6e05";
            case 5:
                return "\u8d85\u6e05";
            case 6:
                return "\u8d85\u84dd\u5149";
            default:
                return "\u672a\u77e5";
        }
    }

    private Drawable j() {
        Resources resources = this.f377541a.getResources();
        if (this.f377543c) {
            return resources.getDrawable(R.drawable.o8g);
        }
        return resources.getDrawable(R.drawable.o8f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(@NonNull List<EnterRoomInfo.VideoDefinition> list) {
        this.f377544d = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(e eVar) {
        this.f377545e = eVar;
    }

    private List<EnterRoomInfo.VideoDefinition> o(@NonNull List<EnterRoomInfo.VideoDefinition> list) {
        ArrayList arrayList = new ArrayList(new HashSet(list));
        Collections.sort(arrayList, new a());
        return arrayList;
    }

    private void p(EnterRoomInfo.VideoDefinition videoDefinition) {
        ViewGroup viewGroup = this.f377542b;
        if (viewGroup == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(R.id.uft);
        for (int i3 = 0; i3 < linearLayout.getChildCount(); i3++) {
            TextView textView = (TextView) linearLayout.getChildAt(i3);
            if (videoDefinition == ((EnterRoomInfo.VideoDefinition) textView.getTag())) {
                q(textView);
            } else {
                r(textView);
            }
        }
    }

    private void q(TextView textView) {
        textView.setTextColor(this.f377541a.getResources().getColor(R.color.bxd));
        textView.setTypeface(Typeface.defaultFromStyle(1));
        Drawable j3 = j();
        if (this.f377543c) {
            textView.setCompoundDrawablesWithIntrinsicBounds(j3, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setCompoundDrawablePadding(4);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, j3, (Drawable) null, (Drawable) null);
            textView.setCompoundDrawablePadding(2);
        }
        textView.setEnabled(false);
    }

    private void r(TextView textView) {
        textView.setTextColor(this.f377541a.getResources().getColor(R.color.bxe));
        textView.setTypeface(Typeface.defaultFromStyle(0));
        textView.setCompoundDrawables(null, null, null, null);
        textView.setEnabled(true);
    }

    public ViewGroup k() {
        return this.f377542b;
    }

    public void m(boolean z16) {
        this.f377543c = z16;
    }

    public void s(EnterRoomInfo.VideoDefinition videoDefinition) {
        QLog.i("AudienceDefinitionView", 1, " selectDefinition:" + videoDefinition);
        p(videoDefinition);
    }
}
