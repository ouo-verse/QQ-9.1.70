package com.tencent.mobileqq.guild.main.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import com.tencent.guild.api.emoji.IGuildTextViewFactoryApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.guild.base.extension.s;
import com.tencent.mobileqq.guild.message.lastmsg.LastMessage;
import com.tencent.mobileqq.guild.summary.GuildSummaryText;
import com.tencent.mobileqq.guild.summary.GuildSummaryUIData;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildSummaryView extends LinearLayout {

    @ColorRes
    private int C;
    private Context D;
    private GuildSummaryUIData E;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f227222d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f227223e;

    /* renamed from: f, reason: collision with root package name */
    private final List<TextView> f227224f;

    /* renamed from: h, reason: collision with root package name */
    private float f227225h;

    /* renamed from: i, reason: collision with root package name */
    private int f227226i;

    /* renamed from: m, reason: collision with root package name */
    @ColorRes
    private int f227227m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f227228a;

        static {
            int[] iArr = new int[GuildSummaryText.TextStyle.values().length];
            f227228a = iArr;
            try {
                iArr[GuildSummaryText.TextStyle.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f227228a[GuildSummaryText.TextStyle.WEAK_BOLD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f227228a[GuildSummaryText.TextStyle.HIGHLIGHT_BOLD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public GuildSummaryView(Context context) {
        super(context);
        this.f227224f = new ArrayList();
        this.f227227m = R.color.bmw;
        this.C = R.color.guild_skin_summary_text_gray;
        this.E = new GuildSummaryUIData();
        c(context, null);
    }

    private void a() {
        this.f227222d = new ImageView(getContext());
        int e16 = QQGuildUIUtil.e(13.0f, getResources());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(e16, e16);
        layoutParams.rightMargin = QQGuildUIUtil.e(4.0f, getResources());
        this.f227222d.setLayoutParams(layoutParams);
        this.f227222d.setImageResource(R.drawable.guild_msg_edit_icon);
        h(this.f227222d, QQGuildUIUtil.f(this.f227225h));
        addView(this.f227222d, 0);
    }

    private void b() {
        int i3;
        this.f227223e = new ImageView(getContext());
        int e16 = QQGuildUIUtil.e(13.0f, getResources());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(e16, e16);
        layoutParams.rightMargin = QQGuildUIUtil.e(4.0f, getResources());
        this.f227223e.setLayoutParams(layoutParams);
        h(this.f227223e, QQGuildUIUtil.f(this.f227225h));
        ImageView imageView = this.f227223e;
        if (this.f227222d == null) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        addView(imageView, i3);
    }

    private void c(Context context, AttributeSet attributeSet) {
        this.D = context;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, up1.a.f439671t5);
            this.f227225h = obtainStyledAttributes.getFloat(up1.a.f439684u5, 12.0f);
            this.f227226i = obtainStyledAttributes.getInteger(up1.a.f439696v5, 400);
            obtainStyledAttributes.recycle();
        } else {
            this.f227225h = 12.0f;
        }
        setGravity(16);
    }

    private void d(boolean z16) {
        if (z16) {
            if (this.f227222d == null) {
                a();
            }
            this.f227222d.setVisibility(0);
            this.f227222d.setImageResource(R.drawable.guild_msg_edit_icon);
            return;
        }
        ImageView imageView = this.f227222d;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private void e(TextView textView, GuildSummaryText guildSummaryText) {
        boolean z16;
        if (!QQEmojiUtil.containsEmoji(guildSummaryText.getContent().toString()) && !QQSysFaceUtil.containsExpression(guildSummaryText.getContent().toString())) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            textView.setPadding(0, 0, QQGuildUIUtil.e(4.0f, getResources()), QQGuildUIUtil.e(2.0f, getResources()));
            textView.setText(new QQText(guildSummaryText.getContent(), 3, 14));
        } else {
            textView.setPadding(0, 0, QQGuildUIUtil.e(4.0f, getResources()), 0);
            textView.setText(guildSummaryText.getContent());
        }
        s.a(textView, this.f227226i, 0);
        int i3 = a.f227228a[guildSummaryText.getStyle().ordinal()];
        if (i3 != 1 && i3 != 2) {
            if (i3 == 3) {
                textView.setTextColor(AppCompatResources.getColorStateList(this.D, this.f227227m));
                return;
            }
            return;
        }
        textView.setTextColor(AppCompatResources.getColorStateList(this.D, this.C));
    }

    private void f(LastMessage.SendState sendState) {
        int i3;
        if (sendState != LastMessage.SendState.SEND_SUCCESS && sendState != LastMessage.SendState.SEND_SUCCESS_NOSEQ) {
            if (this.f227223e == null) {
                b();
            }
            if (sendState == LastMessage.SendState.SEND_FAILED) {
                i3 = R.drawable.guild_msg_failed_icon;
            } else {
                i3 = R.drawable.guild_msg_sending_icon;
            }
            this.f227223e.setImageResource(i3);
            this.f227223e.setVisibility(0);
            return;
        }
        ImageView imageView = this.f227223e;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private void g(@NonNull List<GuildSummaryText> list) {
        for (int i3 = 0; i3 < Math.min(list.size(), this.f227224f.size()); i3++) {
            e(this.f227224f.get(i3), list.get(i3));
            this.f227224f.get(i3).setVisibility(0);
        }
        if (this.f227224f.size() < list.size()) {
            for (int size = this.f227224f.size(); size < list.size(); size++) {
                TextView createGuildETTextView = ((IGuildTextViewFactoryApi) QRoute.api(IGuildTextViewFactoryApi.class)).createGuildETTextView(getContext());
                createGuildETTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                createGuildETTextView.setIncludeFontPadding(false);
                createGuildETTextView.setTextSize(this.f227225h);
                createGuildETTextView.setSingleLine();
                createGuildETTextView.setEllipsize(TextUtils.TruncateAt.END);
                addView(createGuildETTextView);
                e(createGuildETTextView, list.get(size));
                this.f227224f.add(createGuildETTextView);
            }
            return;
        }
        if (this.f227224f.size() > list.size()) {
            for (int size2 = list.size(); size2 < this.f227224f.size(); size2++) {
                this.f227224f.get(size2).setVisibility(8);
            }
        }
    }

    private void h(View view, int i3) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i3;
        view.setLayoutParams(layoutParams);
    }

    public void setSummaryData(GuildSummaryUIData guildSummaryUIData) {
        this.E = guildSummaryUIData;
        d(guildSummaryUIData.getHasDraft());
        f(guildSummaryUIData.getSendState());
        g(guildSummaryUIData.g());
        invalidate();
    }

    public void setSummarySize(float f16) {
        this.f227225h = f16;
    }

    public void setTextColor(@ColorRes int i3, @ColorRes int i16) {
        this.f227227m = i3;
        this.C = i16;
        g(this.E.g());
    }

    public GuildSummaryView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f227224f = new ArrayList();
        this.f227227m = R.color.bmw;
        this.C = R.color.guild_skin_summary_text_gray;
        this.E = new GuildSummaryUIData();
        c(context, attributeSet);
    }

    public GuildSummaryView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f227224f = new ArrayList();
        this.f227227m = R.color.bmw;
        this.C = R.color.guild_skin_summary_text_gray;
        this.E = new GuildSummaryUIData();
        c(context, attributeSet);
    }
}
