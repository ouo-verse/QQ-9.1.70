package com.tencent.biz.qqcircle.debug.mocklbs;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.views.QFSTVKVideoView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.RFWTVKPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerOnInfoListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWTVKOnNetVideoInfoListener;
import com.tencent.biz.richframework.video.rfw.view.RFWVideoView;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleExChangeVideoUrlFragment extends QCircleBaseFragment implements View.OnClickListener {
    private ImageView C;
    private EditText D;
    private TextView E;
    private TextView F;
    private RFWVideoView G;
    private QFSTVKVideoView H;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QCircleExChangeVideoUrlFragment qCircleExChangeVideoUrlFragment = QCircleExChangeVideoUrlFragment.this;
            qCircleExChangeVideoUrlFragment.vh(qCircleExChangeVideoUrlFragment.D);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements IRFWTVKOnNetVideoInfoListener {
        d() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWTVKOnNetVideoInfoListener
        public void onNetVideoInfo(TVKNetVideoInfo tVKNetVideoInfo) {
            RFWLog.d("QCircleMockSchemaFragment", RFWLog.USR, QCircleScheme.AttrDetail.VIDEO_INFO);
        }
    }

    private void finishActivity() {
        if (getHostActivity() != null && !getHostActivity().isDestroyed()) {
            getHostActivity().finish();
        }
    }

    private void sh() {
        QCircleInitBean qCircleInitBean = (QCircleInitBean) getHostActivity().getIntent().getExtras().getSerializable("key_bundle_common_init_bean");
        if (qCircleInitBean != null && qCircleInitBean.getSchemeAttrs() != null && qCircleInitBean.getSchemeAttrs().containsKey("url")) {
            String str = qCircleInitBean.getSchemeAttrs().get("url");
            this.D.setText(URLDecoder.decode(str));
            th(URLDecoder.decode(str));
        }
    }

    private void th(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!uq3.h.d(str) && !str.startsWith("rtmp://")) {
            uh(str);
            return;
        }
        gb0.b.w();
        RFWPlayerOptions playUrl = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).setPlayUrl(str);
        playUrl.getListenerSet().addPrepareListeners(new b());
        this.G.loadPlayOptions(playUrl);
        this.G.setVisibility(0);
        this.H.setVisibility(8);
    }

    private void uh(String str) {
        RFWPlayerOptions tVKPlayerOption = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.TENCENT_VIDEO_PLAYER()).setFromType(8).setTVKPlayerOption(RFWTVKPlayerOptions.obtain().setVid(str).setTVKPlayerType(2));
        tVKPlayerOption.getListenerSet().addPrepareListeners(new e()).addTVKNetVideoInfoListener(new d()).addInfoListener(new c());
        this.H.loadPlayOptions(tVKPlayerOption);
        this.H.setVisibility(0);
        this.G.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vh(EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.setTextIsSelectable(true);
        editText.requestFocus();
        ((InputMethodManager) editText.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(editText, 0);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.g36;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCircleMockSchemaFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return -1;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getHostActivity().getWindow().setSoftInputMode(32);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.y_2) {
            finishActivity();
        } else if (view.getId() == R.id.f94545ck) {
            th(this.D.getText().toString());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.G.release();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        ImageView imageView = (ImageView) ((QCircleBaseFragment) this).mContentView.findViewById(R.id.y_2);
        this.C = imageView;
        imageView.setOnClickListener(this);
        this.D = (EditText) ((QCircleBaseFragment) this).mContentView.findViewById(R.id.f95265ei);
        TextView textView = (TextView) ((QCircleBaseFragment) this).mContentView.findViewById(R.id.f94545ck);
        this.E = textView;
        textView.setOnClickListener(this);
        this.F = (TextView) ((QCircleBaseFragment) this).mContentView.findViewById(R.id.f94555cl);
        this.G = (RFWVideoView) ((QCircleBaseFragment) this).mContentView.findViewById(R.id.f94585co);
        this.H = (QFSTVKVideoView) ((QCircleBaseFragment) this).mContentView.findViewById(R.id.f94575cn);
        this.D.setOnClickListener(new a());
        sh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements IRFWPlayerPrepareListener {
        b() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onVideoPrepared(RFWPlayer rFWPlayer) {
            rFWPlayer.start();
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onFirstFrameRendered(RFWPlayer rFWPlayer) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class e implements IRFWPlayerPrepareListener {
        e() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onVideoPrepared(RFWPlayer rFWPlayer) {
            QCircleExChangeVideoUrlFragment.this.H.start();
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onFirstFrameRendered(RFWPlayer rFWPlayer) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements IRFWPlayerOnInfoListener {
        c() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerOnInfoListener
        public void onInfo(int i3, long j3, long j16, Object obj) {
        }
    }
}
