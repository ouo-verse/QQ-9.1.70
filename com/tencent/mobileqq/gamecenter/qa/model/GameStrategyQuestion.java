package com.tencent.mobileqq.gamecenter.qa.model;

import com.tencent.mobileqq.gamecenter.qa.data.GameStrategyChannelEntry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameStrategyQuestion implements Serializable {
    private static final long serialVersionUID = 1;
    public GameStrategyChannelEntry channelEntry;
    public int mAppId;
    public String mContent;
    public String mRichContent;
    public String mTitle;
    public long questionId;
    private final List<GameStrategyTag> mTags = new ArrayList();
    private final List<GameStrategyPic> mPics = new ArrayList();
    private final List<GameStrategyVideo> mVideos = new ArrayList();
    private final List<GameQALinkCardData> mLinkCards = new ArrayList();

    public void addLinkCards(List<GameQALinkCardData> list) {
        this.mLinkCards.addAll(list);
    }

    public void addPics(List<GameStrategyPic> list) {
        this.mPics.addAll(list);
    }

    public void addTags(List<GameStrategyTag> list) {
        if (list != null && list.size() > 0) {
            this.mTags.clear();
            this.mTags.addAll(list);
        }
    }

    public void addVideos(List<GameStrategyVideo> list) {
        this.mVideos.addAll(list);
    }

    public List<GameQALinkCardData> getLinkCards() {
        return this.mLinkCards;
    }

    public List<GameStrategyPic> getPics() {
        return Collections.unmodifiableList(this.mPics);
    }

    public List<Long> getTagIds() {
        ArrayList arrayList = new ArrayList();
        Iterator<GameStrategyTag> it = this.mTags.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(it.next().mTagId));
        }
        return arrayList;
    }

    public List<GameStrategyTag> getTags() {
        return Collections.unmodifiableList(this.mTags);
    }

    public List<GameStrategyVideo> getVideos() {
        return Collections.unmodifiableList(this.mVideos);
    }
}
