package com.tencent.biz.qqcircle.events;

import com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSPersonalEditViewModel;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QCirclePersonEditUpdateEvent extends SimpleBaseEvent {
    private QFSPersonalEditViewModel.FrequencyItem mAvatar;
    private String mCompany;
    private int mConstellation;
    private QFSPersonalEditViewModel.FrequencyItem mDesc;
    private int mGender;
    private String mGroupIDList;
    private QFSPersonalEditViewModel.Group mGroupInfoList;
    private QFSPersonalEditViewModel.d mGuild;
    private QFSPersonalEditViewModel.e mLocation;
    private QFSPersonalEditViewModel.FrequencyItem mNick;
    private String mSchool;
    private boolean mShowSchool;
    private boolean mUpdateShowSchool;

    public QFSPersonalEditViewModel.FrequencyItem getAvatar() {
        return this.mAvatar;
    }

    public String getCompany() {
        return this.mCompany;
    }

    public int getConstellation() {
        return this.mConstellation;
    }

    public QFSPersonalEditViewModel.FrequencyItem getDesc() {
        return this.mDesc;
    }

    public int getGender() {
        return this.mGender;
    }

    public QFSPersonalEditViewModel.Group getGroupInfoList() {
        return this.mGroupInfoList;
    }

    public QFSPersonalEditViewModel.d getGuild() {
        return this.mGuild;
    }

    public QFSPersonalEditViewModel.e getLocation() {
        return this.mLocation;
    }

    public QFSPersonalEditViewModel.FrequencyItem getNick() {
        return this.mNick;
    }

    public String getSchool() {
        return this.mSchool;
    }

    public boolean getShowSchool() {
        return this.mShowSchool;
    }

    public boolean isUpdateShowSchool() {
        return this.mUpdateShowSchool;
    }

    public void setAvatar(QFSPersonalEditViewModel.FrequencyItem frequencyItem) {
        this.mAvatar = frequencyItem;
    }

    public void setCompany(String str) {
        this.mCompany = str;
    }

    public void setConstellation(int i3) {
        this.mConstellation = i3;
    }

    public void setDesc(QFSPersonalEditViewModel.FrequencyItem frequencyItem) {
        this.mDesc = frequencyItem;
    }

    public void setGender(int i3) {
        this.mGender = i3;
    }

    public void setGroupIDList(String str) {
        this.mGroupIDList = str;
    }

    public void setGroupInfoList(QFSPersonalEditViewModel.Group group) {
        if (group != null) {
            this.mGroupInfoList = group;
        }
    }

    public void setGuild(QFSPersonalEditViewModel.d dVar) {
        this.mGuild = dVar;
    }

    public void setLocation(QFSPersonalEditViewModel.e eVar) {
        this.mLocation = eVar;
    }

    public void setNick(QFSPersonalEditViewModel.FrequencyItem frequencyItem) {
        this.mNick = frequencyItem;
    }

    public void setSchool(String str) {
        this.mSchool = str;
    }

    public void setShowSchool(boolean z16) {
        this.mUpdateShowSchool = true;
        this.mShowSchool = z16;
    }
}
