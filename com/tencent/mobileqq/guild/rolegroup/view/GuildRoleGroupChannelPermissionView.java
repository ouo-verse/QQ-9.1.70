package com.tencent.mobileqq.guild.rolegroup.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes14.dex */
public class GuildRoleGroupChannelPermissionView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private TextView f232803d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f232804e;

    public GuildRoleGroupChannelPermissionView(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        View inflate = View.inflate(context, R.layout.f6_, this);
        this.f232803d = (TextView) inflate.findViewById(R.id.e85);
        this.f232804e = (TextView) inflate.findViewById(R.id.ian);
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, up1.a.P4);
        String string = obtainStyledAttributes.getString(up1.a.Q4);
        String string2 = obtainStyledAttributes.getString(up1.a.R4);
        obtainStyledAttributes.recycle();
        setLeftText(string);
        setRightText(string2);
    }

    public void setChannelInfo(List<String> list, List<String> list2, boolean z16) {
        int i3;
        int i16;
        HashSet hashSet = new HashSet(list);
        if (hashSet.containsAll(list2)) {
            if (z16) {
                i16 = R.string.f146180th;
            } else {
                i16 = R.string.f146170tg;
            }
            setRightText(QQGuildUIUtil.r(i16));
            return;
        }
        hashSet.retainAll(list2);
        if (z16) {
            i3 = R.string.f146320tv;
        } else {
            i3 = R.string.f146310tu;
        }
        setRightText(String.format(QQGuildUIUtil.r(i3), Integer.valueOf(hashSet.size())));
    }

    public void setLeftText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f232803d.setText(str);
        }
    }

    public void setRightText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f232804e.setText(str);
        }
    }

    public GuildRoleGroupChannelPermissionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
        b(context, attributeSet);
    }

    public GuildRoleGroupChannelPermissionView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(context);
        b(context, attributeSet);
    }
}
