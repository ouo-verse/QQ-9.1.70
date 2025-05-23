package org.light.lightAssetKit.components;

import java.util.ArrayList;
import org.light.lightAssetKit.ComponentBase;
import org.light.lightAssetKit.enums.RandomType;

/* compiled from: P */
/* loaded from: classes29.dex */
public class RandomGroup extends Component {
    private RandomType randomType = RandomType.Random;
    private ArrayList<Integer> weights = new ArrayList<>();
    private ArrayList<Integer> selections = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof RandomGroup) {
            RandomGroup randomGroup = (RandomGroup) componentBase;
            this.randomType = randomGroup.randomType;
            this.weights = randomGroup.weights;
            this.selections = randomGroup.selections;
        }
        super.doUpdate(componentBase);
    }

    public RandomType getRandomType() {
        return this.randomType;
    }

    public ArrayList<Integer> getSelections() {
        return this.selections;
    }

    public ArrayList<Integer> getWeights() {
        return this.weights;
    }

    public void setRandomType(RandomType randomType) {
        this.randomType = randomType;
        reportPropertyChange("randomType", randomType);
    }

    public void setSelections(ArrayList<Integer> arrayList) {
        this.selections = arrayList;
        reportPropertyChange("selections", arrayList);
    }

    public void setWeights(ArrayList<Integer> arrayList) {
        this.weights = arrayList;
        reportPropertyChange("weights", arrayList);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "RandomGroup";
    }
}
