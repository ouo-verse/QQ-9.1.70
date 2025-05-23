package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.person.QFSWaveGuildMemberAvatarView;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.MemberInfo;
import com.tencent.trpcprotocol.group_pro.recommend.common.common;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class QFSPersonalDittoFeedGuildItemView extends QCircleBaseWidgetView<com.tencent.biz.qqcircle.immersive.personal.bean.k> {
    private static final HashMap<Integer, String> C;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f89240d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f89241e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f89242f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f89243h;

    /* renamed from: i, reason: collision with root package name */
    private QFSWaveGuildMemberAvatarView f89244i;

    /* renamed from: m, reason: collision with root package name */
    private QFSWaveGuildMemberAvatarView f89245m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends QCirclePicStateListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            if ((loadState == LoadState.STATE_SUCCESS || loadState == LoadState.STATE_DOWNLOAD_SUCCESS) && QFSPersonalDittoFeedGuildItemView.this.f89240d != null) {
                QFSPersonalDittoFeedGuildItemView.this.f89240d.setVisibility(0);
            }
        }
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        C = hashMap;
        hashMap.put(2, QCircleSkinHelper.getInstance().getUrl("qvideo_pindao_live"));
        hashMap.put(3, QCircleSkinHelper.getInstance().getUrl("qvideo_pindao_voice"));
        hashMap.put(4, QCircleSkinHelper.getInstance().getUrl("qvideo_pindao_share"));
        hashMap.put(5, QCircleSkinHelper.getInstance().getUrl("qvideo_pindao_game"));
        hashMap.put(11, QCircleSkinHelper.getInstance().getUrl("qvideo_pindao_music"));
        hashMap.put(12, QCircleSkinHelper.getInstance().getUrl("qvideo_pindao_gaming"));
    }

    public QFSPersonalDittoFeedGuildItemView(@NonNull Context context) {
        super(context);
        r0(this);
    }

    private void m0(com.tencent.biz.qqcircle.immersive.personal.bean.i iVar) {
        if (this.f89241e == null) {
            QLog.e("QFSPersonalDittoFeedGuildItemView", 1, "[initImage] mIvFeed should not be null");
            return;
        }
        String a16 = iVar.a();
        if (TextUtils.isEmpty(a16)) {
            a16 = uq3.c.K2();
        }
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(a16).setTargetView(this.f89241e).setRequestHeight(getMeasuredHeight()).setRequestWidth(getMeasuredWidth()).setLoadingDrawable(new ColorDrawable(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_bg_skeleton))));
    }

    private void n0(com.tencent.biz.qqcircle.immersive.personal.bean.i iVar) {
        ImageView imageView = this.f89240d;
        if (imageView == null) {
            QLog.e("QFSPersonalDittoFeedGuildItemView", 1, "[initLeftTopIcon] mIvTagTop should not be null");
            return;
        }
        imageView.setVisibility(8);
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(C.get(Integer.valueOf(iVar.t()))).setTargetView(this.f89240d).setRequestWidth(ViewUtils.dpToPx(57.0f)).setRequestHeight(ViewUtils.dpToPx(18.0f)), new a());
    }

    private void o0(MemberInfo memberInfo, long j3, QFSWaveGuildMemberAvatarView qFSWaveGuildMemberAvatarView) {
        String str;
        if (memberInfo != null && qFSWaveGuildMemberAvatarView != null) {
            qFSWaveGuildMemberAvatarView.setAvatarMeta(String.valueOf(j3), String.valueOf(memberInfo.getUint64Tinyid()), memberInfo.getBytesAvatarMeta().toStringUtf8());
            if (memberInfo.getUint32Gender() == 2) {
                str = "#FF79D1";
            } else {
                str = "#00B7FF";
            }
            qFSWaveGuildMemberAvatarView.setColor(Color.parseColor(str));
            qFSWaveGuildMemberAvatarView.setVolume(58.0f);
            QLog.d("QFSPersonalDittoFeedGuildItemView", 2, "[initMemberView] guildId = " + j3 + ", memberInfo.getUint64Tinyid() =" + memberInfo.getUint64Tinyid() + ", memberInfo.getBytesAvatarMeta() =" + memberInfo.getBytesAvatarMeta() + ", memberInfo.getBytesAvatarMeta().toString() =" + memberInfo.getBytesAvatarMeta().toString() + ", memberInfo.getBytesAvatarMeta().toStringUtf8() =" + memberInfo.getBytesAvatarMeta().toStringUtf8());
            return;
        }
        QLog.e("QFSPersonalDittoFeedGuildItemView", 1, "[initMemberView] guildId should be null");
    }

    private void p0(common.RCGuildMemberInfo rCGuildMemberInfo, long j3, QFSWaveGuildMemberAvatarView qFSWaveGuildMemberAvatarView) {
        String str;
        if (rCGuildMemberInfo != null && qFSWaveGuildMemberAvatarView != null) {
            qFSWaveGuildMemberAvatarView.setAvatarMeta(String.valueOf(j3), String.valueOf(rCGuildMemberInfo.getTinyId()), rCGuildMemberInfo.getAvatarMeta().toStringUtf8());
            if (rCGuildMemberInfo.getGender() == 2) {
                str = "#FF79D1";
            } else {
                str = "#00B7FF";
            }
            qFSWaveGuildMemberAvatarView.setColor(Color.parseColor(str));
            qFSWaveGuildMemberAvatarView.setVolume(58.0f);
            QLog.d("QFSPersonalDittoFeedGuildItemView", 2, "[initPlayMemberView] guildId = " + j3 + ", memberInfo.getTinyId() =" + rCGuildMemberInfo.getTinyId() + ", memberInfo.getAvatarMeta() =" + rCGuildMemberInfo.getAvatarMeta() + ", memberInfo.getAvatarMeta().toString() =" + rCGuildMemberInfo.getAvatarMeta().toString() + ", memberInfo.getAvatarMeta().toString().toStringUtf8() =" + rCGuildMemberInfo.getAvatarMeta().toStringUtf8());
            return;
        }
        QLog.e("QFSPersonalDittoFeedGuildItemView", 1, "[initPlayMemberView] guildId should be null");
    }

    private void q0(com.tencent.biz.qqcircle.immersive.personal.bean.i iVar) {
        boolean z16;
        int i3;
        int t16 = iVar.t();
        int i16 = 0;
        if (t16 != 3 && t16 != 5 && t16 != 11 && t16 != 12) {
            z16 = false;
        } else {
            z16 = true;
        }
        iVar.D(z16);
        if (this.f89244i != null && this.f89245m != null) {
            QLog.d("QFSPersonalDittoFeedGuildItemView", 1, "[initUserIcon] isShow = " + z16 + ", feedInfo.getMemberNum() = " + iVar.v());
            QFSWaveGuildMemberAvatarView qFSWaveGuildMemberAvatarView = this.f89244i;
            if (z16 && iVar.v() > 0) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            qFSWaveGuildMemberAvatarView.setVisibility(i3);
            QFSWaveGuildMemberAvatarView qFSWaveGuildMemberAvatarView2 = this.f89245m;
            if (!z16 || iVar.v() <= 1) {
                i16 = 8;
            }
            qFSWaveGuildMemberAvatarView2.setVisibility(i16);
            return;
        }
        QLog.e("QFSPersonalDittoFeedGuildItemView", 1, "[initUserIcon] mMemberView1 || mMemberView2 should not be null");
    }

    private void r0(View view) {
        this.f89240d = (ImageView) view.findViewById(R.id.y9q);
        this.f89241e = (ImageView) view.findViewById(R.id.y2y);
        this.f89242f = (ImageView) view.findViewById(R.id.y56);
        this.f89243h = (TextView) view.findViewById(R.id.f109666gf);
        this.f89244i = (QFSWaveGuildMemberAvatarView) view.findViewById(R.id.wqr);
        this.f89245m = (QFSWaveGuildMemberAvatarView) view.findViewById(R.id.wqs);
    }

    private void s0(com.tencent.biz.qqcircle.immersive.personal.bean.i iVar) {
        common.RecommendItem recommendItem;
        String roomPv;
        String str;
        String imageUrl;
        try {
            recommendItem = common.RecommendItem.parseFrom(iVar.b().busiData.get().toByteArray());
        } catch (Exception e16) {
            QLog.e("QFSPersonalDittoFeedGuildItemView", 1, e16, new Object[0]);
            recommendItem = null;
        }
        if (recommendItem == null) {
            QLog.e("QFSPersonalDittoFeedGuildItemView", 1, "[parseChannelData] item should not be null");
            return;
        }
        int itemTypeValue = recommendItem.getItemTypeValue();
        iVar.z(itemTypeValue);
        common.ChannelInfo channelInfo = recommendItem.getChannelInfo();
        long guildId = channelInfo.getGuildId();
        iVar.x(guildId);
        iVar.y(channelInfo.getGuildName());
        iVar.C(channelInfo.getShareLink());
        if (itemTypeValue != 2) {
            if (itemTypeValue != 3 && itemTypeValue != 4 && itemTypeValue != 5 && itemTypeValue != 11) {
                if (itemTypeValue != 12) {
                    str = "";
                    roomPv = "";
                } else {
                    common.VoiceTemplateChannel voiceTemplate = recommendItem.getVoiceTemplate();
                    imageUrl = voiceTemplate.getCover().getImageUrl();
                    roomPv = String.valueOf(voiceTemplate.getCurrentNum());
                    int membersCount = voiceTemplate.getMembersCount();
                    iVar.B(membersCount);
                    if (membersCount > 0) {
                        p0(voiceTemplate.getMembers(0), guildId, this.f89244i);
                    }
                    if (membersCount > 1) {
                        p0(voiceTemplate.getMembers(1), guildId, this.f89245m);
                    }
                }
            } else {
                common.RCGuildVoiceChannel voiceChannel = recommendItem.getVoiceChannel();
                imageUrl = voiceChannel.getCover().getImageUrl();
                roomPv = String.valueOf(voiceChannel.getData().getPresence().getUint32ChannelCurrentNum());
                int rptMemberListCount = voiceChannel.getData().getPresence().getRptMemberListCount();
                iVar.B(rptMemberListCount);
                if (rptMemberListCount > 0) {
                    o0(voiceChannel.getData().getPresence().getRptMemberList(0), guildId, this.f89244i);
                }
                if (rptMemberListCount > 1) {
                    o0(voiceChannel.getData().getPresence().getRptMemberList(1), guildId, this.f89245m);
                }
            }
            str = imageUrl;
        } else {
            common.RCGuildLiveChannel liveChannel = recommendItem.getLiveChannel();
            String imageUrl2 = liveChannel.getCover().getImageUrl();
            roomPv = liveChannel.getData().getPresence().getRoomInfo().getRoomPv();
            str = imageUrl2;
        }
        iVar.g(str);
        iVar.A(roomPv);
        QLog.d("QFSPersonalDittoFeedGuildItemView", 1, "[parseChannelData] QFSPersonalDittoFeedGuildInfo = " + iVar);
    }

    private void u0() {
        QFSWaveGuildMemberAvatarView qFSWaveGuildMemberAvatarView = this.f89244i;
        if (qFSWaveGuildMemberAvatarView != null && qFSWaveGuildMemberAvatarView.getVisibility() == 0) {
            this.f89244i.setVolume(58.0f);
            this.f89244i.start();
        }
        QFSWaveGuildMemberAvatarView qFSWaveGuildMemberAvatarView2 = this.f89245m;
        if (qFSWaveGuildMemberAvatarView2 != null && qFSWaveGuildMemberAvatarView2.getVisibility() == 0) {
            this.f89245m.setVolume(58.0f);
            this.f89245m.start();
        }
    }

    private void v0() {
        QFSWaveGuildMemberAvatarView qFSWaveGuildMemberAvatarView = this.f89244i;
        if (qFSWaveGuildMemberAvatarView != null) {
            qFSWaveGuildMemberAvatarView.stop();
        }
        QFSWaveGuildMemberAvatarView qFSWaveGuildMemberAvatarView2 = this.f89245m;
        if (qFSWaveGuildMemberAvatarView2 != null) {
            qFSWaveGuildMemberAvatarView2.stop();
        }
    }

    private void w0(com.tencent.biz.qqcircle.immersive.personal.bean.i iVar) {
        if (this.f89243h != null && this.f89242f != null) {
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(QCircleSkinHelper.getInstance().getUrl("qvideo_pindao_renshu")).setTargetView(this.f89242f).setRequestWidth(ViewUtils.dpToPx(14.0f)).setRequestHeight(ViewUtils.dpToPx(14.0f)));
            this.f89243h.setText(iVar.u());
            return;
        }
        QLog.e("QFSPersonalDittoFeedGuildItemView", 1, "[updateLeftBottomCount] mTvNum || mIvLeft should not be null");
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.glg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSPersonalDittoFeedGuildItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void bindData(com.tencent.biz.qqcircle.immersive.personal.bean.k kVar, int i3) {
        if (kVar != null && kVar.b() != null) {
            if (!(kVar instanceof com.tencent.biz.qqcircle.immersive.personal.bean.i)) {
                QLog.e("QFSPersonalDittoFeedGuildItemView", 1, "[bindData] is not QFSPersonalDittoFeedGuildInfo");
                return;
            }
            com.tencent.biz.qqcircle.immersive.personal.bean.i iVar = (com.tencent.biz.qqcircle.immersive.personal.bean.i) kVar;
            s0(iVar);
            m0(iVar);
            n0(iVar);
            w0(iVar);
            q0(iVar);
            return;
        }
        QLog.e("QFSPersonalDittoFeedGuildItemView", 1, "[bindData] fsPersonalFeedInfo should not be null");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        u0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        v0();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i3) * 4) / 3, 1073741824));
    }
}
