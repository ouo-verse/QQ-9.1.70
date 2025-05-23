package com.tencent.timi.game.liveroom.impl.test;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.timi.game.ui.widget.CommonButton;
import com.tencent.timi.game.ui.widget.f;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TgLiveRoomOneKeyLiveTestFragment extends QPublicBaseFragment {
    private EditText C;
    private CommonButton D;
    private TextView E;
    private EditText F;
    private View G;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            long parseLong;
            EventCollector.getInstance().onViewClickedBefore(view);
            String obj = TgLiveRoomOneKeyLiveTestFragment.this.C.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                parseLong = -1;
            } else {
                parseLong = Long.parseLong(obj);
            }
            if (parseLong <= 0) {
                f.c("roomId\u65e0\u6548\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165!");
            } else {
                String M2 = ((ni4.a) mm4.b.b(ni4.a.class)).M2(parseLong, "share_qq");
                TgLiveRoomOneKeyLiveTestFragment.this.E.setText("\u8df3\u8f6cScheme\u5982\u4e0b\uff1a\n\n" + M2);
                TgLiveRoomOneKeyLiveTestFragment.this.th(M2);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            String obj = TgLiveRoomOneKeyLiveTestFragment.this.F.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                TgLiveRoomOneKeyLiveTestFragment.this.th(obj);
            } else {
                f.c("Scheme\u65e0\u6548\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165!");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void initView(View view) {
        this.C = (EditText) view.findViewById(R.id.f96325hd);
        this.D = (CommonButton) view.findViewById(R.id.f96305hb);
        this.E = (TextView) view.findViewById(R.id.f96315hc);
        long c16 = ((ni4.a) mm4.b.b(ni4.a.class)).b0().c();
        if (c16 != 0) {
            this.C.setText(String.valueOf(c16));
        }
        this.D.setOnClickListener(new a());
        this.F = (EditText) view.findViewById(R.id.f96125gu);
        view.findViewById(R.id.f96115gt).setOnClickListener(new b());
        view.findViewById(R.id.f96295ha).setOnClickListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void th(String str) {
        bi.c((BaseQQAppInterface) getQBaseActivity().getAppRuntime(), getContext(), str).b();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.hxe, viewGroup, false);
        this.G = inflate;
        initView(inflate);
        View view = this.G;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ((ni4.a) mm4.b.b(ni4.a.class)).b0().a(new a());
            EventCollector.getInstance().onViewClicked(view);
        }

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class a implements nf4.a<Integer> {
            a() {
            }

            @Override // nf4.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Integer num) {
            }

            @Override // nf4.a
            public void onError(int i3, String str) {
            }
        }
    }
}
