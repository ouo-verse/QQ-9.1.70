package com.tencent.mobileqq.profilecard.view.vas.bean;

import java.util.List;

/* compiled from: P */
/* loaded from: classes35.dex */
public class VasCustomBgJson {
    private DiamondsBean avatar;

    /* renamed from: bg, reason: collision with root package name */
    private BgBean f260927bg;
    private ColorBean color;
    private List<DiamondsBean> diamonds;
    private DiamondsBean gameplate;
    private DiamondsBean nameplate;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class BgBean {
        private String anim;
        private String animNight;
        private int nickfont;
        private String res;
        private String resNight;

        public String getAnim() {
            return this.anim;
        }

        public String getAnimNight() {
            return this.animNight;
        }

        public int getNickfont() {
            return this.nickfont;
        }

        public String getRes() {
            return this.res;
        }

        public String getResNight() {
            return this.resNight;
        }

        public void setAnim(String str) {
            this.anim = str;
        }

        public void setAnimNight(String str) {
            this.animNight = str;
        }

        public void setNickfont(int i3) {
            this.nickfont = i3;
        }

        public void setRes(String str) {
            this.res = str;
        }

        public void setResNight(String str) {
            this.resNight = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class ColorBean {
        private String nick;
        private String nickNight;
        private String tagBack;
        private String tagFront;

        public String getNick() {
            return this.nick;
        }

        public String getNickNight() {
            return this.nickNight;
        }

        public String getTagBack() {
            return this.tagBack;
        }

        public String getTagFront() {
            return this.tagFront;
        }

        public void setNick(String str) {
            this.nick = str;
        }

        public void setNickNight(String str) {
            this.nickNight = str;
        }

        public void setTagBack(String str) {
            this.tagBack = str;
        }

        public void setTagFront(String str) {
            this.tagFront = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class DiamondsBean {
        private String anim;
        private List<Integer> center;
        private List<Integer> contentSize;
        private List<Integer> iconSize;
        private String res;
        private float rotate;

        public String getAnim() {
            return this.anim;
        }

        public List<Integer> getCenter() {
            return this.center;
        }

        public List<Integer> getContentSize() {
            return this.contentSize;
        }

        public List<Integer> getIconSize() {
            return this.iconSize;
        }

        public String getRes() {
            return this.res;
        }

        public float getRotate() {
            return this.rotate;
        }

        public void setAnim(String str) {
            this.anim = str;
        }

        public void setCenter(List<Integer> list) {
            this.center = list;
        }

        public void setContentSize(List<Integer> list) {
            this.contentSize = list;
        }

        public void setIconSize(List<Integer> list) {
            this.iconSize = list;
        }

        public void setRes(String str) {
            this.res = str;
        }

        public void setRotate(float f16) {
            this.rotate = f16;
        }
    }

    public DiamondsBean getAvatar() {
        return this.avatar;
    }

    public BgBean getBg() {
        return this.f260927bg;
    }

    public ColorBean getColor() {
        return this.color;
    }

    public List<DiamondsBean> getDiamonds() {
        return this.diamonds;
    }

    public DiamondsBean getGameplate() {
        return this.gameplate;
    }

    public DiamondsBean getNameplate() {
        return this.nameplate;
    }

    public void setAvatar(DiamondsBean diamondsBean) {
        this.avatar = diamondsBean;
    }

    public void setBg(BgBean bgBean) {
        this.f260927bg = bgBean;
    }

    public void setColor(ColorBean colorBean) {
        this.color = colorBean;
    }

    public void setDiamonds(List<DiamondsBean> list) {
        this.diamonds = list;
    }

    public void setGameplate(DiamondsBean diamondsBean) {
        this.gameplate = diamondsBean;
    }

    public void setNameplate(DiamondsBean diamondsBean) {
        this.nameplate = diamondsBean;
    }
}
