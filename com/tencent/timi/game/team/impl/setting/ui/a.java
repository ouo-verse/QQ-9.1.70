package com.tencent.timi.game.team.impl.setting.ui;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigItem;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigLinkageOption;
import trpc.yes.common.YoloRoomOuterClass$ListParam;
import trpc.yes.common.YoloRoomOuterClass$YoloGameRoomParams;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    protected int C;

    /* renamed from: d, reason: collision with root package name */
    protected InterfaceC9978a f379674d;

    /* renamed from: e, reason: collision with root package name */
    protected com.tencent.timi.game.team.impl.main.d f379675e;

    /* renamed from: f, reason: collision with root package name */
    protected YesGameInfoOuterClass$GameConfigItem f379676f;

    /* renamed from: h, reason: collision with root package name */
    protected List<YesGameInfoOuterClass$GameConfigLinkageOption> f379677h;

    /* renamed from: i, reason: collision with root package name */
    protected View f379678i;

    /* renamed from: m, reason: collision with root package name */
    protected int f379679m;

    /* compiled from: P */
    /* renamed from: com.tencent.timi.game.team.impl.setting.ui.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public interface InterfaceC9978a {
        void a(List<YesGameInfoOuterClass$GameConfigLinkageOption> list, boolean z16);
    }

    public a(@NonNull View view) {
        this.f379678i = view;
    }

    private void e(YesGameInfoOuterClass$GameConfigItem yesGameInfoOuterClass$GameConfigItem, com.tencent.timi.game.team.impl.main.d dVar, List<YesGameInfoOuterClass$GameConfigLinkageOption> list, int i3) {
        this.f379676f = yesGameInfoOuterClass$GameConfigItem;
        this.f379675e = dVar;
        this.f379679m = i3;
        this.f379677h = list;
        this.C = yesGameInfoOuterClass$GameConfigItem.index.get();
    }

    public void c(YesGameInfoOuterClass$GameConfigItem yesGameInfoOuterClass$GameConfigItem, com.tencent.timi.game.team.impl.main.d dVar, List<YesGameInfoOuterClass$GameConfigLinkageOption> list, int i3) {
        e(yesGameInfoOuterClass$GameConfigItem, dVar, list, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(YesGameInfoOuterClass$GameConfigItem yesGameInfoOuterClass$GameConfigItem, TextView textView) {
        String str = yesGameInfoOuterClass$GameConfigItem.title.get();
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        }
        String str2 = this.f379675e.f379564i.team_info.text_hue.get();
        if (yn4.a.a(str2)) {
            textView.setTextColor(Color.parseColor(str2));
        }
    }

    public View h() {
        return this.f379678i;
    }

    public int i() {
        return this.C;
    }

    public YesGameInfoOuterClass$GameConfigLinkageOption j() {
        List<YesGameInfoOuterClass$GameConfigLinkageOption> list = this.f379677h;
        if (list != null && !list.isEmpty()) {
            for (YesGameInfoOuterClass$GameConfigLinkageOption yesGameInfoOuterClass$GameConfigLinkageOption : this.f379677h) {
                if (yesGameInfoOuterClass$GameConfigLinkageOption.index.get() == this.C) {
                    return yesGameInfoOuterClass$GameConfigLinkageOption;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<String> k() {
        List<YoloRoomOuterClass$ListParam> list = this.f379675e.f379568m;
        if (list == null) {
            return new ArrayList();
        }
        for (YoloRoomOuterClass$ListParam yoloRoomOuterClass$ListParam : list) {
            if (yoloRoomOuterClass$ListParam.index.get() == this.C) {
                return yoloRoomOuterClass$ListParam.value.get();
            }
        }
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean l() {
        if (this.f379679m == 0) {
            return true;
        }
        return false;
    }

    public boolean m() {
        List<YesGameInfoOuterClass$GameConfigLinkageOption> list = this.f379677h;
        if (list != null && !list.isEmpty()) {
            for (YesGameInfoOuterClass$GameConfigLinkageOption yesGameInfoOuterClass$GameConfigLinkageOption : this.f379677h) {
                if (yesGameInfoOuterClass$GameConfigLinkageOption.index.get() == this.C && !yesGameInfoOuterClass$GameConfigLinkageOption.key.isEmpty()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void n(List<YesGameInfoOuterClass$GameConfigLinkageOption> list) {
        this.f379677h = list;
    }

    public void o(InterfaceC9978a interfaceC9978a) {
        this.f379674d = interfaceC9978a;
    }

    public void f() {
    }

    public void g(YoloRoomOuterClass$YoloGameRoomParams yoloRoomOuterClass$YoloGameRoomParams) {
    }
}
