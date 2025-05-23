package com.qzone.proxy.feedcomponent.ui;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.oskplayer.PlayerConfig;

/* compiled from: P */
/* loaded from: classes39.dex */
public class m implements PlayerResources {
    @Override // com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources
    public int getAnimationId(int i3) {
        return 0;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources
    public int getColor(int i3) {
        return 0;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources
    public Drawable getDrawable(int i3) {
        try {
            return PlayerConfig.g().getAppContext().getResources().getDrawable(getDrawableId(i3));
        } catch (Exception unused) {
            return new ColorDrawable(0);
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources
    public int getDrawableId(int i3) {
        switch (i3) {
            case 1093:
                return R.drawable.gce;
            case 1094:
                return R.drawable.ghl;
            case 1095:
                return R.drawable.gcf;
            case 1096:
            case 1099:
                return R.drawable.gci;
            case 1097:
            case 1098:
                return R.drawable.gcg;
            case 1100:
            case 1101:
            case 1102:
            default:
                return 0;
            case 1103:
                return R.drawable.f162304gc3;
            case 1104:
                return R.drawable.f162305gc4;
            case 1105:
                return R.drawable.gc7;
            case 1106:
                return R.drawable.gc9;
            case 1107:
                return R.drawable.gc8;
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources
    public int getInteger(int i3) {
        return 0;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources
    public int getLayoutId(int i3) {
        if (i3 != 8) {
            return 0;
        }
        return R.layout.bpe;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources
    public int getRawId(int i3) {
        return 0;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources
    public String getString(int i3) {
        return null;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources
    public CharSequence getText(int i3) {
        return null;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources
    public int getViewId(int i3) {
        if (i3 != 29) {
            if (i3 != 564) {
                switch (i3) {
                    case 547:
                        return R.id.how;
                    case PlayerResources.ViewId.VIDEO_SURFACE /* 548 */:
                        return R.id.hov;
                    case 549:
                        return R.id.f167092kq3;
                    case 550:
                        return R.id.hoh;
                    case PlayerResources.ViewId.TITLE_BAR /* 551 */:
                        return R.id.hon;
                    case 552:
                        return R.id.hnp;
                    case PlayerResources.ViewId.LOADING /* 553 */:
                        return R.id.f166730ho2;
                    case PlayerResources.ViewId.SWITCH_LANDSCAPE_BUTTON /* 554 */:
                        return R.id.hoj;
                    case 555:
                        return R.id.f166728ho0;
                    case PlayerResources.ViewId.CONTROLLER_PROGRESS /* 556 */:
                        return R.id.f166731ho3;
                    case PlayerResources.ViewId.PLAYER_DURATION /* 557 */:
                        return R.id.hnv;
                    case PlayerResources.ViewId.CURRUNT_TIME /* 558 */:
                        return R.id.hom;
                    default:
                        switch (i3) {
                            case PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT /* 576 */:
                                return R.id.hns;
                            case 577:
                                return R.id.hnq;
                            case 578:
                                return R.id.hok;
                            case 579:
                                return R.id.hou;
                            case 580:
                                return R.id.hoo;
                            default:
                                return 0;
                        }
                }
            }
            return R.id.f166406f93;
        }
        return R.id.hnt;
    }
}
