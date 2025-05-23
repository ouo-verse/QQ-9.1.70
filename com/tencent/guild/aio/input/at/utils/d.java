package com.tencent.guild.aio.input.at.utils;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.widget.EditText;
import com.tencent.guild.aio.input.at.utils.d;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildChannelIconUtil;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes6.dex */
public class d extends f {

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f111105a;

        /* renamed from: b, reason: collision with root package name */
        public String f111106b;

        /* renamed from: c, reason: collision with root package name */
        public int f111107c;

        /* renamed from: d, reason: collision with root package name */
        public Paint f111108d;

        /* renamed from: e, reason: collision with root package name */
        public int f111109e;

        /* renamed from: g, reason: collision with root package name */
        public boolean f111111g;

        /* renamed from: i, reason: collision with root package name */
        public int f111113i;

        /* renamed from: l, reason: collision with root package name */
        public Drawable f111116l;

        /* renamed from: f, reason: collision with root package name */
        public int f111110f = 0;

        /* renamed from: h, reason: collision with root package name */
        public boolean f111112h = false;

        /* renamed from: j, reason: collision with root package name */
        public int f111114j = -1;

        /* renamed from: k, reason: collision with root package name */
        public boolean f111115k = false;
    }

    protected d(Context context, String str, String str2, int i3, Paint paint, int i16, int i17, Drawable drawable) {
        super(context, str, str2, i3, paint, i16, i17, drawable);
    }

    public static SpannableString u(Context context, final a aVar) {
        int i3;
        String str;
        SpannableString spannableString = null;
        if (aVar != null && context != null && aVar.f111108d != null) {
            int i16 = aVar.f111110f;
            if (aVar.f111111g) {
                i3 = 0;
            } else {
                i3 = i16;
            }
            if (aVar.f111115k && aVar.f111116l == null) {
                Drawable drawable = context.getResources().getDrawable(GuildChannelIconUtil.f235331a.k(aVar.f111105a, aVar.f111113i, new Function1() { // from class: com.tencent.guild.aio.input.at.utils.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit y16;
                        y16 = d.y(d.a.this, (Integer) obj);
                        return y16;
                    }
                }));
                aVar.f111116l = drawable;
                if (drawable != null) {
                    if (aVar.f111114j < 0) {
                        aVar.f111114j = aVar.f111108d.getColor();
                    }
                    aVar.f111116l = GuildUIUtils.f235378a.F(aVar.f111116l, aVar.f111114j);
                }
            }
            try {
                d dVar = new d(context, aVar.f111105a, aVar.f111106b, aVar.f111109e, aVar.f111108d, i3, aVar.f111113i, aVar.f111116l);
                dVar.s(aVar.f111107c);
                String replaceAll = AtTroopMemberSpan.m(dVar.p()).replaceAll("[\r\n]", " ");
                if (aVar.f111112h) {
                    str = replaceAll + " ";
                } else {
                    str = replaceAll;
                }
                spannableString = new SpannableString(str);
                spannableString.setSpan(dVar, 0, replaceAll.length(), 33);
            } catch (OutOfMemoryError unused) {
            }
        }
        return spannableString;
    }

    public static SpannableString v(Context context, String str, String str2, EditText editText, int i3, boolean z16, boolean z17, int i16) {
        if (editText == null) {
            return null;
        }
        a aVar = new a();
        aVar.f111105a = str;
        aVar.f111106b = str2;
        aVar.f111108d = editText.getPaint();
        aVar.f111109e = (editText.getMeasuredWidth() - editText.getPaddingLeft()) - editText.getPaddingRight();
        if (editText.getPaint() != null) {
            aVar.f111114j = context.getResources().getColor(x(z16));
            editText.getPaint().setColor(aVar.f111114j);
        }
        aVar.f111110f = i3;
        aVar.f111111g = z16;
        aVar.f111112h = z17;
        aVar.f111113i = i16;
        aVar.f111115k = false;
        return u(context, aVar);
    }

    public static SpannableString w(Context context, String str, String str2, int i3, EditText editText, int i16, boolean z16, boolean z17, int i17, Drawable drawable) {
        if (editText == null) {
            return null;
        }
        a aVar = new a();
        aVar.f111107c = i3;
        aVar.f111105a = str;
        aVar.f111106b = str2;
        aVar.f111108d = editText.getPaint();
        aVar.f111109e = (editText.getMeasuredWidth() - editText.getPaddingLeft()) - editText.getPaddingRight();
        if (editText.getPaint() != null) {
            aVar.f111114j = context.getResources().getColor(x(z16));
            editText.getPaint().setColor(aVar.f111114j);
        }
        aVar.f111110f = i16;
        aVar.f111111g = z16;
        aVar.f111112h = z17;
        aVar.f111113i = i17;
        aVar.f111115k = true;
        aVar.f111116l = drawable;
        return u(context, aVar);
    }

    private static int x(boolean z16) {
        if (z16) {
            return R.color.bql;
        }
        return R.color.qui_common_text_link;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit y(a aVar, Integer num) {
        aVar.f111107c = num.intValue();
        return Unit.INSTANCE;
    }
}
